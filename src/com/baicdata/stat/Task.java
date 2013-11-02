package com.baicdata.stat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.adp.java.AdPlan;
import com.adp.java.FlowSrc;
import com.adp.java.PlanStatus;
import com.adp.java.ReportFormService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.sql.*;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Task implements Runnable {
	private HashMap<String, Double> CostCache;
    private HashMap<String, Double> CostCacheTimestamp;
	private HashMap<String, Integer> CostStatusCache;
    private HashMap<String, Long> CostStatusCacheTimestamp;
	private HashMap<String, Integer> PSCStatusCache;
    private HashMap<String, Long> PSCStatusCacheTimestamp;
	private HashMap<String, Double> AccountCache;
    private HashMap<String, Double> AccountCacheTimestamp;
    private HashMap<String, Double> BudgetCache;
    private HashMap<String, Double> BudgetCacheTimestamp;
	private SimpleDateFormat formater = null;
	private String host = null;
	private int port = 0;
	private String database = null;
	private String prefix = null;
	private String suffix = null;
	private DB db = null;
	private String url = null;
	private String user = null;
	private String password = null;
	private String url2 = null;
	private String user2 = null;
	private String password2 = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String separator = null;
	private Hashtable<String, String> p = null;
	private Hashtable<String, String> g = null;
	private Hashtable<String, String> u = null;
	private int push_date = 0;
	private int push_area = 0;
	private int push_source = 0;
	private int push_adid = 0;
	private int push_pushid = 0;
	private int show_date = 0;
	private int show_area = 0;
	private int show_source = 0;
	private int show_adid = 0;
	private int show_pushid = 0;
	private int click_date = 0;
	private int click_area = 0;
	private int click_source = 0;
	private int click_adid = 0;
	private int click_pushid = 0;
	private int res_date = 0;
	private int res_area = 0;
	private int res_source = 0;
	private int res_adid = 0;
	private int res_pushid = 0;
	private int res_cost = 0;
	private Connection conn = null;
	

	public Task(String h, int p, String d, String pf, String sf, String url,
			String user, String password, String pat, String sep,
			int push_date, int push_area, int push_source, int push_adid,
			int push_pushid, int show_date, int show_area, int show_source,
			int show_adid, int show_pushid, int click_date, int click_area,
			int click_source, int click_adid, int click_pushid, int res_date,
			int res_area, int res_source, int res_adid, int res_pushid,
			int res_cost, String url2, String user2, String password2) {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.CostCache = new HashMap<String, Double>();
		this.CostStatusCache = new HashMap<String, Integer>();
		this.CostStatusCacheTimestamp = new HashMap<String, Long>();
		this.PSCStatusCacheTimestamp = new HashMap<String, Long>();
		this.PSCStatusCache = new HashMap<String, Integer>();
		this.AccountCache = new HashMap<String, Double>();
		this.BudgetCache = new HashMap<String, Double>();
		this.formater = new SimpleDateFormat(pat);
		this.host = h;
		this.port = p;
		this.database = d;
		this.prefix = pf;
		this.suffix = sf;
		this.url = url;
		this.user = user;
		this.password = password;
		this.url2 = url;
		this.user2 = user;
		this.password2 = password;
		this.separator = sep;
		this.p = new Hashtable<String, String>();
		this.g = new Hashtable<String, String>();
		this.u = new Hashtable<String, String>();

		this.push_date = push_date;
		this.push_area = push_area;
		this.push_source = push_source;
		this.push_adid = push_adid;
		this.push_pushid = push_pushid;

		this.show_date = show_date;
		this.show_area = show_area;
		this.show_source = show_source;
		this.show_adid = show_adid;
		this.show_pushid = show_pushid;

		this.click_date = click_date;
		this.click_area = click_area;
		this.click_source = click_source;
		this.click_adid = click_adid;
		this.click_pushid = click_pushid;

		this.res_date = res_date;
		this.res_area = res_area;
		this.res_source = res_source;
		this.res_adid = res_adid;
		this.res_pushid = res_pushid;

		this.res_cost = res_cost;
		this.conn = null;
		try {
			this.conn = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String host = p.getProperty("host");
		int port = Integer.parseInt(p.getProperty("mongoport"));
		String database = p.getProperty("database");
		String logprefix = p.getProperty("logprefix");
		String logsuffix = p.getProperty("logsuffix");
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		String url2 = p.getProperty("url2");
		String user2 = p.getProperty("user2");
		String password2 = p.getProperty("password2");
		String pat = p.getProperty("logpartten");
		String sep = p.getProperty("separator");
		int push_date = Integer.parseInt(p.getProperty("push_date"));
		int push_area = Integer.parseInt(p.getProperty("push_area"));
		int push_source = Integer.parseInt(p.getProperty("push_source"));
		int push_adid = Integer.parseInt(p.getProperty("push_adid"));
		int push_pushid = Integer.parseInt(p.getProperty("push_pushid"));
		int show_date = Integer.parseInt(p.getProperty("show_date"));
		int show_area = Integer.parseInt(p.getProperty("show_area"));
		int show_source = Integer.parseInt(p.getProperty("show_source"));
		int show_adid = Integer.parseInt(p.getProperty("show_adid"));
		int show_pushid = Integer.parseInt(p.getProperty("show_pushid"));
		int click_date = Integer.parseInt(p.getProperty("click_date"));
		int click_area = Integer.parseInt(p.getProperty("click_area"));
		int click_source = Integer.parseInt(p.getProperty("click_source"));
		int click_adid = Integer.parseInt(p.getProperty("click_adid"));
		int click_pushid = Integer.parseInt(p.getProperty("click_pushid"));
		int res_date = Integer.parseInt(p.getProperty("res_date"));
		int res_area = Integer.parseInt(p.getProperty("res_area"));
		int res_source = Integer.parseInt(p.getProperty("res_source"));
		int res_adid = Integer.parseInt(p.getProperty("res_adid"));
		int res_pushid = Integer.parseInt(p.getProperty("res_pushid"));
		int res_cost = Integer.parseInt(p.getProperty("res_cost"));
		new Task(host, port, database, logprefix, logsuffix, url, user,
				password, pat, sep, push_date, push_area, push_source,
				push_adid, push_pushid, show_date, show_area, show_source,
				show_adid, show_pushid, click_date, click_area, click_source,
				click_adid, click_pushid, res_date, res_area, res_source,
				res_adid, res_pushid, res_cost, url2, user2, password2).run();
	}

	public String getdate(String datetime) {
		String[] s = datetime.split(" ")[0].split("-");
		return s[0] + s[1] + s[2];
	}

	public String[] getinfo(String adid) {
		if (this.g.containsKey(adid)) {
			String uid = this.u.get(adid);
			String pid = this.p.get(adid);
			String gid = this.g.get(adid);
			String[] ret = { uid, pid, gid };
			return ret;
		}
		try {
			//Class.forName(this.driver);
			//try {
				// System.out.println(this.url+"+"+this.user+"+"+this.password);
				if (this.conn == null) {
					this.conn = DriverManager.getConnection(this.url, this.user, this.password);
				}
				Statement statement = conn.createStatement();
				String sql = "select * from adp_ad_info where adid=" + adid;

				ResultSet rs = statement.executeQuery(sql);
				String uid = null;
				String gid = null;
				String pid = null;
				while (rs.next()) {
					uid = rs.getString("uid");
					pid = rs.getString("plan_id");
					gid = rs.getString("group_id");
				}
				rs.close();
//				conn.close();
				if (uid != null) this.u.put(adid, uid);
				if (pid != null) this.p.put(adid, pid);
				if (gid != null) this.g.put(adid, gid);
				String[] ret = { uid, pid, gid };
				return ret;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		//} catch (ClassNotFoundException e) {
		//	e.printStackTrace();
		//}
		return null;
	}


	public String getid(String id) {
		int i = 0;
		String a = "";
		for (i = 0; i < id.length() && id.charAt(i) == '0'; i++);
		if (i == id.length()) a = "0";
		else a = id.substring(i);
		String ret = "";
		for (i = 0; i < a.length(); i++) {
			if (a.charAt(i) <= '9' && a.charAt(i) >= '0') ret += a.charAt(i);
		}
		if (ret.equals("")) ret = "0";
		return ret;
	}

	public boolean isvalid(String type, String pushid) {
		boolean ret = false;// String retmsg = "";
		if (type.equals("bidres")) {
			ret = isvalidcost(pushid);
//			retmsg = "to isvalid cost";
		}
		else {
			boolean b = this.PSCStatusCache.containsKey(pushid);
//			System.out.println(this.PSCStatusCache.size());
			if (b) {
				int a = this.PSCStatusCache.get(pushid);
//				System.out.println(a);
				if (a == 4 && type.equals("show")) {
					ret = true;
//					retmsg = "b is true and value is 4";
				} else if (a == 6 && type.equals("click")) {
					ret = true;
//					retmsg = "b is true and value is 6";
				} else {
//					retmsg = "b is true and value is other status";
					ret = false;
				}
			} else {
				if (type.equals("push")) {
					ret = true;
//					retmsg = "b is false and type is push";
				} else {
//					retmsg = "b is f/alse and type is others";
					ret = false;
				}
			}
		}
//		System.out.println(type+" - "+pushid+" : "+ret + " => " + retmsg);
		return ret;
	}

	public boolean isvalidcost(String pushid) {
		return !this.CostStatusCache.containsKey(pushid);
	}

	public boolean changestat(String pushid, long timestamp) {
		this.CostStatusCache.put(pushid, 1);
        this.CostStatusCacheTimestamp.put(pushid, timestamp);
		return true;
	}

	private boolean save(String collection, DBObject query, DBObject data) {
		return this.db.getCollection(collection).update(query, data, true, false).getN() == 1;
	}
	private double getBudget(String timestamp, String pid) {
		String key = pid+"+"+timestamp;
		if(this.BudgetCache.containsKey(key))return this.BudgetCache.get(key);
		if(this.conn==null) {
			try {
				this.conn = DriverManager.getConnection(this.url, this.user, this.password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql = "select budget from adp_plan_info where plan_id="+ pid;
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		double budget = 0;
		try {
			while (rs.next())
				budget = rs.getFloat("budget");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.BudgetCache.put(key, budget);
		return budget;
	}
	private double getAccount(String timestamp, String uid) {
		String key = uid+"+"+timestamp;
		if(this.AccountCache.containsKey(key))return this.AccountCache.get(key);
		String sql = "select account from adp_user_info where uid="+ uid;
		if (this.conn==null)
			try {
				this.conn = DriverManager.getConnection(this.url, this.user, this.password);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double account = 0;
		try {
			while (rs.next())account  = rs.getFloat("account");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.AccountCache.put(key, account);
		return account;
	}
	public double getDayCost(String timestamp, String pid) {
		double ret = 0;
		Mongo mongo = null;
		Date d = new Date();
		String cachekey = String.format("%s|%s", pid, timestamp);
		if (this.CostCache.containsKey(cachekey)) return this.CostCache.get(cachekey);
		try {
			mongo = new Mongo(this.host, this.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return ret;
		}
		if (mongo != null) {
			String today = new SimpleDateFormat("yyyyMMdd").format(d);			
			DBCollection col = mongo.getDB(this.database).getCollection("DayDetail");
			DBObject query = new BasicDBObject();
			query.put("pid", pid);
			query.put("time", today);
			DBObject key = new BasicDBObject();
			key.put("pid", pid);
			DBObject cond = new BasicDBObject();
			cond = query;
			DBObject initial = new BasicDBObject();
			initial.put("cost", 0);
			String reduce = "function(curr,result){if(curr.cost!=null)result.cost+=curr.cost;}";
			List<Object> returnList = (BasicDBList) col.group(key, cond, initial, reduce);
			for (int i = 0; i < returnList.size(); i++) {
				try {
					ret += Float.valueOf(((DBObject) returnList.get(i)).get("cost").toString());
				} catch (java.lang.NullPointerException e) {
					e.printStackTrace();
				}
			}
			
		}
        this.CostCache.put(cachekey, ret);
		mongo.close();
		return ret;
	}

	private void StopAPlan(String pid) {
		TTransport transport = null;
		transport = new TSocket("112.124.46.78", 9098);
		TProtocol protocol = new TBinaryProtocol(transport);
		ReportFormService.Client client = new ReportFormService.Client(protocol);
		try {
			transport.open();
		} catch (TTransportException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("stop plan:"+pid+"("+client.updateAdPlanStatus(Integer.parseInt(pid), PlanStatus.STOPPED)+")");
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (TException e1) {
			e1.printStackTrace();
		}
		transport.close();	
	}

	private void StopAllPlan(String uid) {
		TTransport transport = null;
		transport = new TSocket("112.124.46.78", 9098);
		TProtocol protocol = new TBinaryProtocol(transport);
		ReportFormService.Client client = new ReportFormService.Client(protocol);
		try {
			transport.open();
		} catch (TTransportException e1) {
			e1.printStackTrace();
		}
		ArrayList<String> pids = new ArrayList<String>();
		try {
			List<AdPlan> a = client.getAdPlansByUid(Integer.parseInt(uid));
			for(AdPlan ap : a) {
				pids.add(String.valueOf(ap.plan_id));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
		for (String pid:pids) {
			try {
				System.out.println("frozen plan:"+pid+"("+client.updateAdPlanStatus(Integer.parseInt(pid), PlanStatus.STOPPED)+")");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (TException e1) {
				e1.printStackTrace();
			}
		}
		transport.close();	
		
	}
	 
	private void CutDown(String uid, Double charge) {
			if (this.conn == null) {
				try {
					this.conn = DriverManager.getConnection(this.url, this.user, this.password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			Statement statement = null;
			try {
				statement = conn.createStatement();
				statement.executeUpdate("update adp_user_info set account=account-" + String.format("%s", charge) + " where uid=" + uid);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void run() {
		System.out.println("task start at " + new Date().toString());
		Mongo mongo = null;
		try {
			mongo = new Mongo(this.host, this.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if (mongo != null) {
			this.db = mongo.getDB(this.database);
			long currentTimestamp = System.currentTimeMillis() - 30000;
			String RunAt = this.formater.format(new Date(currentTimestamp));
			String InputPath = this.prefix + RunAt + this.suffix;
			System.out.println("<begin>");
			System.out.println("Input: " + InputPath);
			String line = null;
			File f = new File(InputPath);
			if (f.exists()) {
				String timestmp = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
                long timestampl = currentTimestamp/1000;
				System.out.println("log found.");
				try {
					System.out.println("GO");
					BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(f)));
					HashMap<String, Long> psave = new HashMap<String, Long>();
					HashMap<String, Long> ssave = new HashMap<String, Long>();
					HashMap<String, Long> csave = new HashMap<String, Long>();
					HashMap<String, Double> costsave = new HashMap<String, Double>();
					HashMap<String, Double> cdsave = new HashMap<String, Double>();
					while ((line = br.readLine()) != null) {
						/* String[] segments = line.split(this.separator); */
						
						String[] segments = line.split("\u0001");
						String[] segments2 = segments[0].split(" ");
						if (segments.length >= 7 && segments2.length == 2) {
//							System.out.println("in:"+System.nanoTime());
							String type = segments2[1];
							String version = segments[1];

							String date = null, area = null, source = null, id = null, pushid = null;
							boolean T = false;
							int change = 0;
							if (type.equals("rtb_creative") && version.equals("1")) {
								date = getdate(segments[this.push_date]);
								try {
									area = segments[this.push_area];
								} catch (Exception e) {
									area = "-1";
								}
								source = segments[this.push_source];
								id = getid(segments[this.push_adid]);
								pushid = segments[this.push_pushid];
								T = true;
								type = "push";
								change = 4;
							} else if (type.equals("rtb_show")
									&& version.equals("1")) {
								date = getdate(segments[this.show_date]);
								try {
									area = segments[this.show_area];
								} catch (Exception e) {
									area = "-1";
								}
								source = segments[this.show_source];
								id = getid(segments[this.show_adid]);
								pushid = segments[this.show_pushid];
								T = true;
								type = "show";
								change = 2;
							} else if (type.equals("rtb_bidres")
									&& version.equals("1")) {
								date = getdate(segments[this.res_date]);
								try {
									area = segments[this.res_area];
								} catch (Exception e) {
									area = "-1";
								}
								source = segments[this.res_source];
								id = getid(segments[this.res_adid]);
								pushid = segments[this.res_pushid];
								T = true;
								type = "bidres";
								change = 1;
							} else if (type.equals("rtb_click")
									&& version.equals("1")) {
								date = getdate(segments[this.click_date]);
								try {
									area = segments[this.click_area];
								} catch (Exception e) {
									area = "-1";
								}
								source = segments[this.click_source];
								id = getid(segments[this.click_adid]);
								pushid = segments[this.click_pushid];
								T = true;
								type = "click";
								change = 1;
							}
//							double times = 0, times2 = 0;
							//////////////////////
							if (T && isvalid(type, pushid)) {
//								System.out.println("Type:<" + type + "> Date:<"+ date + "> Area:<" + area+ "> Source:<" + source + "> ID:<" + id+ ">");
//								times2 = System.nanoTime();
								
//								DBObject query = new BasicDBObject();
								String info[] = this.getinfo(id);
								String uid = info[0];
								String pid = info[1];
								String gid = info[2];
//								query.put("time", date);
//								query.put("uid", uid);
//								query.put("pid", pid);
//								query.put("gid", gid);
//								query.put("area", area);
//								query.put("source", source);
//								query.put("adid", id);
//								DBObject data = new BasicDBObject();
								double charge = 0.0f;
								if (type.equals("bidres")) {
									try {
										charge = Float.parseFloat(segments[this.res_cost])/1000;
										if(charge>0 && charge<0.01){
											changestat(pushid, timestampl);
											type = "cost";
										}
									} catch (Exception e) {
									}
								} else {
									charge = 1;
								}
								
//								data.put("$inc", new BasicDBObject(type, charge));
//								System.out.println("Set:"+(System.nanoTime()-times2)/1000);
								String querykey = String.format("%s,%s,%s,%s,%s,%s,%s", date, uid, pid, gid, area, source, id);
//								times = System.nanoTime();
								// TODO NOTICE
//								this.save("DayDetail", query, data);
								if (type.equals("push")) {
									if (psave.containsKey(querykey)) psave.put(querykey, psave.get(querykey)+1);
									else psave.put(querykey, 1L);
								} else if (type.equals("show")) {
									if (ssave.containsKey(querykey)) ssave.put(querykey, ssave.get(querykey)+1);
									else ssave.put(querykey, 1L);
								} else if (type.equals("click")) {
									if (csave.containsKey(querykey)) csave.put(querykey, csave.get(querykey)+1);
									else csave.put(querykey, 1L);
								} else if (type.equals("cost")) {
									if (costsave.containsKey(querykey)) costsave.put(querykey, costsave.get(querykey)+charge);
									else costsave.put(querykey, charge);
								}
								
//								System.out.println("Save:"+(System.nanoTime()-times)/1000);
								
//								times = System.nanoTime();
								
//								System.out.println("PSC:"+(System.nanoTime()-times)/1000);
								
								// TODO NOTICE
								if (type.equals("cost")) {
//									times = System.nanoTime();
//									CutDown(uid, charge);
									if (cdsave.containsKey(uid)) cdsave.put(uid, cdsave.get(uid)+charge);
									else cdsave.put(uid, charge);
									double TodayGroupCost = getDayCost(timestmp, pid);
									double budget = getBudget(timestmp, pid);
									double account = getAccount(timestmp, uid);
									
									if (budget>0&&TodayGroupCost >= budget) {
										StopAPlan(pid);
									}
									if (account <= 0) {
										StopAllPlan(uid);
									}
//									System.out.println("cost:"+(System.nanoTime()-times)/1000);
								} else {
									if (this.PSCStatusCache.containsKey(pushid)) {
										this.PSCStatusCache.put(pushid, this.PSCStatusCache.get(pushid)+change);
	                                    this.PSCStatusCacheTimestamp.put(pushid, timestampl);
									} else {
										this.PSCStatusCache.put(pushid, change);
	                                    this.PSCStatusCacheTimestamp.put(pushid, timestampl);
									}
								}
								
							}
//							System.out.println("total:"+(System.nanoTime()-times2)/1000);
							/////////////////////////
						} else {
							System.out.print(Arrays.toString(segments));
							System.out.println("bad record.");
						}
					}
					for(String i : psave.keySet()) {
						DBObject query = new BasicDBObject();
						String seg[] = i.split(",");
						query.put("time", seg[0]);
						query.put("uid", seg[1]);
						query.put("pid", seg[2]);
						query.put("gid", seg[3]);
						query.put("area", seg[4]);
						query.put("source", seg[5]);
						query.put("adid", seg[6]);
						DBObject data = new BasicDBObject();
						data.put("$inc", new BasicDBObject("push", psave.get(i)));
						System.out.println("Push:"+i+":"+psave.get(i));
						this.save("DayDetail", query, data);
					}
					for(String i : ssave.keySet()) {
						DBObject query = new BasicDBObject();
						String seg[] = i.split(",");
						query.put("time", seg[0]);
						query.put("uid", seg[1]);
						query.put("pid", seg[2]);
						query.put("gid", seg[3]);
						query.put("area", seg[4]);
						query.put("source", seg[5]);
						query.put("adid", seg[6]);
						DBObject data = new BasicDBObject();
						data.put("$inc", new BasicDBObject("show", ssave.get(i)));
						System.out.println("Show:"+i+":"+ssave.get(i));
						this.save("DayDetail", query, data);
					}
					for(String i : csave.keySet()) {
						DBObject query = new BasicDBObject();
						String seg[] = i.split(",");
						query.put("time", seg[0]);
						query.put("uid", seg[1]);
						query.put("pid", seg[2]);
						query.put("gid", seg[3]);
						query.put("area", seg[4]);
						query.put("source", seg[5]);
						query.put("adid", seg[6]);
						DBObject data = new BasicDBObject();
						data.put("$inc", new BasicDBObject("click", csave.get(i)));
						System.out.println("Click:"+i+":"+csave.get(i));
						this.save("DayDetail", query, data);
					}
					for(String i : costsave.keySet()) {
						DBObject query = new BasicDBObject();
						String seg[] = i.split(",");
						query.put("time", seg[0]);
						query.put("uid", seg[1]);
						query.put("pid", seg[2]);
						query.put("gid", seg[3]);
						query.put("area", seg[4]);
						query.put("source", seg[5]);
						query.put("adid", seg[6]);
						DBObject data = new BasicDBObject();
						data.put("$inc", new BasicDBObject("cost", costsave.get(i)));
						System.out.println("Cost:"+i+":"+costsave.get(i));
						this.save("DayDetail", query, data);
					}
					for(String i : cdsave.keySet()) {
						System.out.println("CutDown:"+i+":"+cdsave.get(i));
						CutDown(i, cdsave.get(i));
					}
					System.out.println("OK");
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Reduce Cache
		        HashSet<String> toBeClean = new HashSet<String>();
		        long timestampl2 = timestampl - 1800;
		        long timestampl3 = timestampl - 1800;
		        for (String id : this.PSCStatusCache.keySet()) {
		        	if (this.PSCStatusCacheTimestamp.get(id)<timestampl2) {
		        		toBeClean.add(id);
		        	}
		        }
		        for(Iterator<String> it=toBeClean.iterator();it.hasNext();)
		        {
		        	String id = it.next();
		        	this.PSCStatusCache.remove(id);
		        	this.PSCStatusCacheTimestamp.remove(id);
		        }
		        toBeClean.clear();
		        for (String id : this.CostStatusCache.keySet()) {
		        	if (this.CostStatusCacheTimestamp.get(id)<timestampl2) {
		        		toBeClean.add(id);
		        	}
		        }
		        for(Iterator<String> it=toBeClean.iterator();it.hasNext();)
		        {
		        	String id = it.next();
		        	this.CostStatusCache.remove(id);
		        	this.CostStatusCacheTimestamp.remove(id);
		        }
		        
			} else {
				System.out.println("log miss!");
			}
			System.out.println("<end>");
			mongo.close();
			
		} else {
			System.out.println("<begin>can not connect mongodb<end>");
		}
		System.out.println("task complete at " + new Date().toString());
		
		
	}

}
