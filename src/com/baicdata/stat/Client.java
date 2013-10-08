package com.baicdata.stat;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.adp.java.FlowSrc;

public class Client {

	public void startClient(String config) {
		TTransport transport;
		try {
			System.out.println("read config from: " + config);
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(config);
			Properties p = new Properties();
			try {
				p.load(inputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			transport = new TSocket("localhost", Integer.parseInt(p
					.getProperty("port")));
			TProtocol protocol = new TBinaryProtocol(transport);
			ReportService.Client client = new ReportService.Client(protocol);
			transport.open();

			String Uid = "1";
			String Start = "20110101", End = "20900909";
			
			queryOptions Q1 = new queryOptions();
			Q1.setId(Uid);
			Q1.setStartAt(Start);
			Q1.setEndAt(End);
			pageOptions P1 = new pageOptions();
			P1.setPageNumber(1);
			
			System.out.println(Q1);
			System.out.println(P1);
			try {
				System.out.println(client.PlanReportByUid(Q1, P1));
			} catch (TApplicationException e) {
				e.printStackTrace();
			}
			

			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.startClient(args[0]);

	}
}