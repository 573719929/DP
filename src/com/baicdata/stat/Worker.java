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

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
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
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(config);
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
		reportResult r = new reportResult();
		r.setTotalPage(0);
		r.setCurrentSize(0);
		r.setTotalSize(0);
		r.setPageNumber(0);
		r.setData(new ArrayList<Response>());

		try {
			this.mongo = new Mongo(this.host, this.port);
		} catch (UnknownHostException e) {
			return r;
		}
		int total = 0;
		if (this.mongo != null) {
			DBCollection col = this.mongo.getDB(this.database).getCollection(
					"DayDetail");
			DBObject query = new BasicDBObject();
			query.put(input, q.id);
			DBObject datetime = new BasicDBObject();
			datetime.put("$gt", q.startAt);
			datetime.put("$lt", q.endAt);
			query.put("time", datetime);
			DBObject area = new BasicDBObject();
			if (q.areaid != null && !q.areaid.isEmpty()) {
				area.put("$in", q.areaid);
				query.put("area", area);
			}
			String source = null;
			if (q.source == FlowSrc.self_media) {
				source = "self_media";
			} else if (q.source == FlowSrc.doubleclick) {
				source = "doubleclick";
			} else if (q.source == FlowSrc.sax) {
				source = "sax";
			} else if (q.source == FlowSrc.tanx) {
				source = "tanx";
			} else if (q.source == FlowSrc.tencent) {
				source = "tencent";
			} else if (q.source == FlowSrc.youku) {
				source = "youku";
			}
			if (source != null)
				query.put("source", source);

			DBObject key = new BasicDBObject();
			key.put(output, q.id);

			DBObject cond = new BasicDBObject();
			cond = query;
			DBObject initial = new BasicDBObject();
			initial.put("push", 0);
			initial.put("show", 0);
			initial.put("click", 0);
			initial.put("cost", 0);

			String reduce = "function(curr,result){if(curr.push!=null)result.push+=curr.push;if(curr.show!=null)result.show+=curr.show;if(curr.click!=null)result.click+=curr.click;if(curr.cost!=null)result.cost+=curr.cost;}";

			List<Object> returnList = (BasicDBList) col.group(key, cond,
					initial, reduce);

			total = returnList.size();
			int fromIndex = p.pageSize * (p.pageNumber - 1);
			if (fromIndex < 0)
				fromIndex = 0;
			int toIndex = p.pageSize * (p.pageNumber);
			if (toIndex > returnList.size())
				toIndex = returnList.size();

			if (total > 0 && toIndex >= fromIndex) {

				returnList = returnList.subList(fromIndex, toIndex);
				DBObject t = null;

				for (int i = 0; i < returnList.size(); i++) {

					t = (DBObject) returnList.get(i);
					String id = null;
					try {
						id = t.get(output).toString();
					} catch (java.lang.NullPointerException e) {
					}
					int push = 0, show = 0, click = 0;
					double cost = 0.0;
					try {
						push = Float.valueOf(t.get("push").toString())
								.intValue();
					} catch (java.lang.NullPointerException e) {
					}
					try {
						show = Float.valueOf(t.get("show").toString())
								.intValue();
					} catch (java.lang.NullPointerException e) {
					}
					try {
						click = Float.valueOf(t.get("click").toString())
								.intValue();
					} catch (java.lang.NullPointerException e) {
					}
					try {
						cost = Float.valueOf(t.get("cost").toString());
					} catch (java.lang.NullPointerException e) {
					}
					r.data.add(new Response(id, push, show, click, cost));
				}
			}
		}
		this.mongo.close();
		r.setTotalSize(total);
		r.setCurrentSize(r.getData().size());
		if (p.getPageSize() != 0)
			r.setTotalPage((int) (r.getTotalSize() * 1.0 / p.getPageSize()) + 1);
		else
			r.setTotalPage(0);
		r.setPageNumber(p.getPageNumber());
		this.mongo = null;
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
		// TODO Auto-generated method stub
		return null;
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

}