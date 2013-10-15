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

	public void startClient(String args[]) {
		TTransport transport;
		try {
			
			transport = new TSocket("localhost", 12545);
			TProtocol protocol = new TBinaryProtocol(transport);
			ReportService.Client client = new ReportService.Client(protocol);
			transport.open();

			String Uid = args[0];
			String Start = args[1], End = args[2];
			
			queryOptions Q = new queryOptions();
			Q.setId(Uid);
			Q.setStartAt(Start);
			Q.setEndAt(End);
			pageOptions P = new pageOptions();
			P.setPageNumber(1); P.setPageSize(1000);
			System.out.println(Q);
			System.out.println(P);

			try {
				System.out.println(client.AdReportByAdid(Q, P));
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
		client.startClient(args);

	}
}