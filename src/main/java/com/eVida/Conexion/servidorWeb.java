package com.eVida.Conexion;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class servidorWeb {
	
	protected int port = 80;
	protected HttpServer server;
	
	public servidorWeb() throws IOException {
		server = HttpServer.create(new InetSocketAddress(port) , 0);
		System.out.println("server started at: " + port);
		server.createContext("/" , new RootHandler());
		server.createContext("/echoHeader", new EchoHeaderHandler());
		server.createContext("/echoGet", new EchoGetHandler());
		server.createContext("/echoPost", new EchoPostHandler());
		server.setExecutor(null);
		server.start();
	}
	
	public static void main(String[] args) {
		try {
			servidorWeb w = new servidorWeb();
			System.out.println("Started");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
