package com.baicdata.stat;

/*
 * { "_id" : "adid:98|uid:10|group_id:74|plan_id:20|time:2013-8-3|area:11010000|source:4", "uid" : 10, "show" : 385, "adid" : 98, "click" : 16, "area" : "11010000", "planid" : 20, "source" : "4", "time" : "2013-8-3", "push" : 410, "groupid" : 74 }
 * { "_id" : "adid:90|uid:10|group_id:71|plan_id:20|time:2013-9-13|area:85120000|source:1", "uid" : 10, "show" : 88, "adid" : 90, "click" : 4, "area" : "85120000", "planid" : 20, "source" : "1", "time" : "2013-9-13", "push" : 104, "groupid" : 71 }
 * { "_id" : "adid:98|uid:10|group_id:74|plan_id:20|time:2013-5-17|area:14220000|source:6", "uid" : 10, "show" : 115, "adid" : 98, "click" : 6, "area" : "14220000", "planid" : 20, "source" : "6", "time" : "2013-5-17", "push" : 136, "groupid" : 74 }
 * { "_id" : "adid:102|uid:10|group_id:63|plan_id:20|time:2013-11-4|area:c73df474|source:7", "uid" : 10, "show" : 154, "adid" : 102, "click" : 16, "area" : "c73df474", "planid" : 20, "source" : "7", "time" : "2013-11-4", "push" : 188, "groupid" : 63 }
 * { "_id" : "adid:82|uid:10|group_id:63|plan_id:20|time:2013-11-30|area:99990001|source:3", "uid" : 10, "show" : 375, "adid" : 82, "click" : 21, "area" : "99990001", "planid" : 20, "source" : "3", "time" : "2013-11-30", "push" : 422, "groupid" : 63 }
 * { "_id" : "adid:106|uid:10|group_id:67|plan_id:22|time:2013-9-25|area:22009999|source:2", "uid" : 10, "show" : 413, "adid" : 106, "click" : 35, "area" : "22009999", "planid" : 22, "source" : "2", "time" : "2013-9-25", "push" : 445, "groupid" : 67 }
 * { "_id" : "adid:101|uid:10|group_id:76|plan_id:20|time:2013-12-28|area:33009999|source:7", "uid" : 10, "show" : 384, "adid" : 101, "click" : 38, "area" : "33009999", "planid" : 20, "source" : "7", "time" : "2013-12-28", "push" : 480, "groupid" : 76 }
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.thrift.TException;

import com.adp.java.FlowSrc;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class Worker implements ReportService.Iface {
	private String host = "";
	private int port = 0;
	private String database = "";
	private Mongo mongo = null;

	public Worker(String config) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(config);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this.host = p.getProperty("host");
		this.port = Integer.parseInt(p.getProperty("mongoport"));
		this.database = p.getProperty("database");
		this.mongo = null;
	}

	@Override
	public reportResult AdReportByGroupId(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "gid", "adid");
	}

	@Override
	public reportResult GroupReportByPlanId(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "pid", "gid");
	}

	private reportResult parse(queryOptions q, pageOptions p, String input,
			String output) {
		System.out.println(String.format("input at: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
		reportResult r = new reportResult();
		r.setTotalPage(0);
		r.setCurrentSize(0);
		r.setTotalSize(0);
		r.setPageNumber(0);
		r.setData(new ArrayList<Response>());
		
		if (this.mongo == null) {
			try {
				this.mongo = new Mongo(this.host, this.port);
			} catch (UnknownHostException e) {
				return r;
			}
		}
//		System.out.println(String.format("A: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
		int total = 0;
		if (this.mongo != null) {
			DBCollection col = this.mongo.getDB(this.database).getCollection("DayDetail");
			DBObject query = new BasicDBObject();
			
			query.put(input, q.id);
			
			DBObject datetime = new BasicDBObject();
			datetime.put("$gte", q.startAt); datetime.put("$lte", q.endAt);
			query.put("time", datetime);
			
			DBObject area = new BasicDBObject();
			if (q.areaid != null && !q.areaid.isEmpty()) { area.put("$in", q.areaid);
			query.put("area", area); }
			
			String source = null;
			if (q.source == FlowSrc.self_media)source = "self_media";
			else if (q.source == FlowSrc.doubleclick)source = "doubleclick";
			else if (q.source == FlowSrc.sax)source = "sax";
			else if (q.source == FlowSrc.tanx)source = "tanx";
			else if (q.source == FlowSrc.tencent)source = "tencent";
			else if (q.source == FlowSrc.youku)source = "youku";
			if (source != null)query.put("source", source);

			DBObject key = new BasicDBObject();
			key.put(output, true);
			key.put("push", true);
			key.put("show", true);
			key.put("click", true);
			key.put("cost", true);
			/*
			DBObject initial = new BasicDBObject();
			initial.put("push", 0);
			initial.put("show", 0);
			initial.put("click", 0);
			initial.put("cost", 0);
			String reduce = "function(curr,result){
			if(curr.push!=null)result.push+=(+curr.push);
			if(curr.show!=null)result.show+=(+curr.show);
			if(curr.click!=null)result.click+=(+curr.click);
			if(curr.cost!=null)result.cost+=(+curr.cost);
			}";
			*/
			
			HashMap<String, Double> Pd = new HashMap<String, Double>();
			HashMap<String, Double> Sd = new HashMap<String, Double>();
			HashMap<String, Double> Cd = new HashMap<String, Double>();
			HashMap<String, Double> Qd = new HashMap<String, Double>();
			try{
				//b = col.group(key, query, initial, reduce); // Slowly damn.
//				System.out.println(query);
//				System.out.println(key);
//				System.out.println(String.format("B: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
				DBCursor b = col.find(query, key);
				System.out.println(String.format("C: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
				// Slow Start
				while (b.hasNext()) {
					DBObject t = b.next();
					String k = (String) t.get(output);
					Object pp = t.get("push");
					Object ss = t.get("show");
					Object cc = t.get("click");
					Object coco = t.get("cost");
					if (pp != null) {
						if (Pd.containsKey(k)) {
							Pd.put(k, Pd.get(k)+Double.parseDouble(pp.toString()));
						} else {
							Pd.put(k, Double.parseDouble(pp.toString()));
						}
					}
					if (ss != null) {
						if (Sd.containsKey(k)) {
							Sd.put(k, Sd.get(k)+Double.parseDouble(ss.toString()));
						} else {
							Sd.put(k, Double.parseDouble(ss.toString()));
						}
					}
					if (cc != null) {
						if (Cd.containsKey(k)) {
							Cd.put(k, Cd.get(k)+Double.parseDouble(cc.toString()));
						} else {
							Cd.put(k, Double.parseDouble(cc.toString()));
						}
					}
					if (coco != null) {
						if (Qd.containsKey(k)) {
							Qd.put(k, Qd.get(k)+Double.parseDouble(coco.toString()));
						} else {
							Qd.put(k, Double.parseDouble(coco.toString()));
						}
					}
				}
				// Slow end
				System.out.println(String.format("D: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
			}catch(Exception e) {e.printStackTrace();}			
			//List<Object> returnList = (BasicDBList) b;
			
			ArrayList<String> rr = new ArrayList<String>();
			for (String i : Pd.keySet()) rr.add(i);
//			System.out.println(String.format("E: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
			Collections.sort(rr);
//			System.out.println(String.format("F: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
			total = rr.size();
			int fromIndex = p.pageSize * (p.pageNumber - 1), toIndex = p.pageSize * (p.pageNumber);
			if (fromIndex < 0) fromIndex = 0;
			if (toIndex > rr.size()) toIndex = rr.size();
//			System.out.println(String.format("G: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
			if (total > 0 && toIndex >= fromIndex) {
				List<String> returnList = rr.subList(fromIndex, toIndex);
				String t = null;
				for (int i = 0; i < returnList.size(); i++) {
					t = returnList.get(i);
					String id = null;
					try {
						id = t;
					} catch (java.lang.NullPointerException e) {
					}
					int push = 0, show = 0, click = 0;
					double cost = 0.0;
					try {
						push = Pd.get(t).intValue();
					} catch (java.lang.NullPointerException e) {
					}
					try {
						show = Sd.get(t).intValue();
					} catch (java.lang.NullPointerException e) {
					}
					try {
						click = Cd.get(t).intValue();
					} catch (java.lang.NullPointerException e) {
					}
					try {
						cost = Qd.get(t);
					} catch (java.lang.NullPointerException e) {
					}
					r.data.add(new Response(id, push, show, click, cost));
				}
			}
		}
//		System.out.println(String.format("H: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
//		this.mongo.close();
		r.setTotalSize(total);
		r.setCurrentSize(r.getData().size());
		
		if (p.getPageSize() != 0) {
			
			r.setTotalPage((int) (r.getTotalSize() * 1.0 / p.getPageSize()) + 1);
		}
		else {
			r.setTotalPage(0);
		}
		r.setPageNumber(p.getPageNumber());
		
//		this.mongo = null;
		System.out.println(String.format("output at: %s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss - SS").format(new Date())));
		System.out.println("\n");
		return r;
	}

	@Override
	public reportResult PlanReportByUid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "uid", "pid");
	}

	@Override
	public void ping(int ignoreme) throws TException {
		System.out.println("input:" + ignoreme);
	}

	public reportResult AdAreaDetailReportByGroupId(queryOptions q,
			pageOptions p) throws TException {
		return parse(q, p, "gid", "area");
	}

	public reportResult GroupAreaDetailReportByPlanId(queryOptions q,
			pageOptions p) throws TException {
		return parse(q, p, "pid", "area");
	}

	public reportResult PlanAreaDetailReportByUid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "uid", "area");
	}

	public reportResult AdDayDetailReportByGroupId(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "gid", "time");
	}

	public reportResult GroupDayDetailReportByPlanId(queryOptions q,
			pageOptions p) throws TException {
		return parse(q, p, "pid", "time");
	}

	public reportResult PlanDayDetailReportByUid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "uid", "time");
	}

	public reportResult AdSourceDetailReportByGroupId(queryOptions q,
			pageOptions p) throws TException {
		return parse(q, p, "gid", "source");
	}

	public reportResult GroupSourceDetailReportByPlanId(queryOptions q,
			pageOptions p) throws TException {
		return parse(q, p, "pid", "source");
	}

	public reportResult PlanSourceDetailReportByUid(queryOptions q,
			pageOptions p) throws TException {
		return parse(q, p, "uid", "source");
	}

	@Override
	public reportResult AdReportByAdid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "adid", "adid");
	}

	@Override
	public reportResult AreaByAdid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "adid", "area");
	}

	@Override
	public reportResult AreaByGid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "gid", "area");
	}

	@Override
	public reportResult AreaByPid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "pid", "area");
	}

	@Override
	public reportResult AreaByUid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "uid", "area");
	}

	@Override
	public reportResult DayByAdid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "adid", "time");
	}

	@Override
	public reportResult DayByGid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "gid", "time");
	}

	@Override
	public reportResult DayByPid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "pid", "time");
	}

	@Override
	public reportResult DayByUid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "uid", "time");
	}

	@Override
	public reportResult SourceByAdid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "adid", "source");
	}

	@Override
	public reportResult SourceByGid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "gid", "source");
	}

	@Override
	public reportResult SourceByPid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "pid", "source");
	}

	@Override
	public reportResult SourceByUid(queryOptions q, pageOptions p)
			throws TException {
		return parse(q, p, "uid", "source");
	}

	@Override
	public reportResult HourByAdid(queryOptions q, pageOptions p)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public reportResult HourByGid(queryOptions q, pageOptions p)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public reportResult HourByPid(queryOptions q, pageOptions p)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public reportResult HourByUid(queryOptions q, pageOptions p)
			throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCostByUid(queryOptions q) throws TException {
		double ret = 0.0d;
		
		pageOptions p = new pageOptions();
		p.setPageNumber(1); p.setPageSize(1000);
		reportResult r = parse(q, p, "uid", "pid");
		if(r.data!=null){

			for(Response r2:r.data)
			{

				ret += r2.cost;
			}
		}

		return ret;
	}

}