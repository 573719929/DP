package com.baicdata.stat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import it.sauronsoftware.cron4j.Scheduler;

public class App {

	/**
	 * @param args
	 */
	public static boolean tobecontinued() {
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(args[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
		Scheduler scheduler = new Scheduler();
		scheduler.schedule("*/1 * * * *", new Task(host, port, database,
				logprefix, logsuffix, url, user, password, pat, sep, push_date,
				push_area, push_source, push_adid, push_pushid, show_date,
				show_area, show_source, show_adid, show_pushid, click_date,
				click_area, click_source, click_adid, click_pushid, res_date,
				res_area, res_source, res_adid, res_pushid, res_cost, url2, user2,
				password2));
		scheduler.start();
		while (tobecontinued()) {
			try {
				Thread.sleep(60L * 60L * 1000L);
			} catch (InterruptedException e) {
				;
			}
		}
		scheduler.stop();

	}

}
