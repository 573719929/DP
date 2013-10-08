package com.baicdata.stat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.baicdata.stat.ReportService.Processor;

public class Server {
	public void startServer(String config) {
		try {
			System.out.println("read config from: "+config);
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(config);
			Properties p = new Properties();
			try {
				p.load(inputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			TServerSocket serverTransport = new TServerSocket(
					Integer.parseInt(p.getProperty("port")));
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ReportService.Processor process = new Processor(new Worker(config));
			Factory portFactory = new TBinaryProtocol.Factory(true, true);
			Args args = new Args(serverTransport);
			args.processor(process);
			args.protocolFactory(portFactory);
			TServer server = new TThreadPoolServer(args);
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		System.out.println("Start");
		server.startServer(args[0]);
		System.out.println("Complete");
	}
}