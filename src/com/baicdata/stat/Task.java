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
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.sql.*;

public class Task implements Runnable {
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

	public Task(String h, int p, String d, String pf, String sf, String url,
			String user, String password, String pat, String sep,
			int push_date, int push_area, int push_source, int push_adid,
			int push_pushid, int show_date, int show_area, int show_source,
			int show_adid, int show_pushid, int click_date, int click_area,
			int click_source, int click_adid, int click_pushid, int res_date,
			int res_area, int res_source, int res_adid, int res_pushid,
			int res_cost, String url2, String user2, String password2) {

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
			Class.forName(this.driver);
			try {
				// System.out.println(this.url+"+"+this.user+"+"+this.password);
				Connection conn = DriverManager.getConnection(this.url,
						this.user, this.password);
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
					// System.out.println(uid + "," + pid + "," + gid);
				}
				rs.close();
				conn.close();
				if (uid != null)
					this.u.put(adid, uid);
				if (pid != null)
					this.p.put(adid, pid);
				if (gid != null)
					this.g.put(adid, gid);
				String[] ret = { uid, pid, gid };
				return ret;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getarea(String areaid) {
		return areaid;
	}

	public String getsource(String source) {
		return source;
	}

	public String getid(String id) {
		int i = 0;
		String a = "";
		for (i = 0; i < id.length() && id.charAt(i) == '0'; i++)
			;
		if (i == id.length())
			a = "0";
		else
			a = id.substring(i);
		String ret = "";
		for (i = 0; i < a.length(); i++) {
			if (a.charAt(i) <= '9' && a.charAt(i) >= '0')
				ret += a.charAt(i);
		}
		if (ret.equals(""))
			ret = "0";
		// System.out.println("return adid:" + ret);
		return ret;
	}

	public boolean isvalid(String type, String pushid) {
		if (type.equals("bidres"))
			return isvalidcost(pushid);
		List<DBObject> cur = this.db.getCollection("pushidstatus")
				.find(new BasicDBObject("pushid", pushid)).toArray();
		int a = 0;
		if (cur.size() > 0) {
			BasicDBObject d = (BasicDBObject) cur.get(0);
			// System.out.println(d.toString());
			// System.out.println(d.get("status"));
			a = Integer.parseInt(d.getString("status"));
		}
		// System.out.println(cur.size());
		if (cur.size() == 0 && type.equals("push"))
			return true;
		if (cur.size() != 1)
			return false;
		try {
			// System.out.println(a);
			if (type.equals("show") && a == 4)
				return true;
			else if (type.equals("click") && a == 6)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.toString() + "isvalid is not work properly");
			return false;
		}
	}

	public boolean isvalidcost(String pushid) {
		List<DBObject> cur = this.db.getCollection("pushidcost")
				.find(new BasicDBObject("pushid", pushid)).toArray();
		int a = 0;
		if (cur.size() > 0) {
			BasicDBObject d = (BasicDBObject) cur.get(0);
			a = Integer.parseInt(d.getString("status"));
		}
		if (cur.size() == 0)
			return true;
		if (cur.size() != 1)
			return false;
		try {
			if (a == 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.toString() + "isvalid is not work properly");
			return false;
		}
	}

	public boolean changestat(String pushid) {
		BasicDBObject query = new BasicDBObject();
		query.put("pushid", pushid);
		BasicDBObject data = new BasicDBObject();
		data.put("$inc", new BasicDBObject("status", 1));

		return this.save("pushidcost", query, data);
	}

	private boolean save(String collection, DBObject query, DBObject data) {
		// System.out.print(query);
		// System.out.print("\t");
		// System.out.println(data);
		boolean ret = this.db.getCollection(collection)
				.update(query, data, true, false).getN() == 1;
		// System.out.println(ret);
		return ret;
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
			// System.out.println("RunAt: " + RunAt);
			String line = null;
			File f = new File(InputPath);
			if (f.exists()) {
				System.out.println("log found.");
				try {
					System.out.println("GO");
					BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(f)));
					while ((line = br.readLine()) != null) {
						/* String[] segments = line.split(this.separator); */
						String[] segments = line.split("\u0001");
						String[] segments2 = segments[0].split(" ");
						if (segments.length >= 7 && segments2.length == 2) {
							String type = segments2[1];
							String version = segments[1];

							String date = null;
							String area = null;
							String source = null;
							String id = null;
							String pushid = null;
							boolean T = false;
							int change = 0;
							if (type.equals("rtb_creative")
									&& version.equals("1")) {
								date = getdate(segments[this.push_date]);
								try {
									area = getarea(segments[this.push_area]);
								} catch (Exception e) {
									area = "-1";
								}
								source = getsource(segments[this.push_source]);
								id = getid(segments[this.push_adid]);
								pushid = segments[this.push_pushid];
								T = true;
								type = "push";
								change = 4;
							} else if (type.equals("rtb_show")
									&& version.equals("1")) {
								date = getdate(segments[this.show_date]);
								try {
									area = getarea(segments[this.show_area]);
								} catch (Exception e) {
									area = "-1";
								}
								source = getsource(segments[this.show_source]);
								id = getid(segments[this.show_adid]);
								pushid = segments[this.show_pushid];
								T = true;
								type = "show";
								change = 2;
							} else if (type.equals("rtb_bidres")
									&& version.equals("1")) {
								date = getdate(segments[this.res_date]);
								try {
									area = getarea(segments[this.res_area]);
								} catch (Exception e) {
									area = "-1";
								}
								source = getsource(segments[this.res_source]);
								id = getid(segments[this.res_adid]);
								pushid = segments[this.res_pushid];
								T = true;
								type = "bidres";
								change = 1;
							} else if (type.equals("rtb_click")
									&& version.equals("1")) {
								date = getdate(segments[this.click_date]);
								try {
									area = getarea(segments[this.click_area]);
								} catch (Exception e) {
									area = "-1";
								}
								source = getsource(segments[this.click_source]);
								id = getid(segments[this.click_adid]);
								pushid = segments[this.click_pushid];
								T = true;
								type = "click";
								change = 1;
							}
							if (T && isvalid(type, pushid)) {
								// System.out.println("Get:" + type + "_" +
								// version);
								System.out.println("Type:<" + type + "> Date:<"
										+ date + "> Area:<" + area
										+ "> Source:<" + source + "> ID:<" + id
										+ ">");
								DBObject query = new BasicDBObject();
								String info[] = this.getinfo(id);
								String uid = info[0];
								String pid = info[1];
								String gid = info[2];
								query.put("time", date);
								query.put("uid", uid);
								query.put("pid", pid);
								query.put("gid", gid);
								query.put("area", area);
								query.put("source", source);
								query.put("adid", id);
								DBObject data = new BasicDBObject();
								float charge = 0.0f;
								if (type.equals("bidres")) {
									try {
										charge = Float
												.parseFloat(segments[this.res_cost]);
										type = "cost";
									} catch (Exception e) {

									}
								} else
									charge = 1;
								data.put("$inc",
										new BasicDBObject(type, charge));
								this.save("DayDetail", query, data);

								query = new BasicDBObject();
								query.put("pushid", pushid);
								data = new BasicDBObject();
								data.put("$inc", new BasicDBObject("status",
										change));

								this.save("pushidstatus", query, data);

							} else {
								// System.out.println("unknown type");
							}
						} else {
							// System.out.print(Arrays.toString(segments));
							// System.out.println("bad record.");
						}
					}
					System.out.println("OK");
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
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
