package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CommunicaTCPServer {

	private ServerSocket serverSock;
	private int portNumber;
	
	public CommunicaTCPServer(int portNumber) {
		try {
			this.portNumber = portNumber;
			serverSock = new ServerSocket(this.portNumber);
		} catch (IOException e) {
			System.out.println("Can not listen to port : " + portNumber);
			System.exit(-1);
		}
	}
	
	public Socket accept() {
		Socket clientSock = null;
		try {
			System.out.println("Listening to connection requests...");
			clientSock = serverSock.accept();
		} catch (IOException e) {
			System.out.println("Accept failed : port " + portNumber);
			System.exit(-1);
		}
		System.out.println("Request accepted : " 
						+ "name = " + clientSock.getInetAddress().getCanonicalHostName() 
						+ ", port = " + clientSock.getLocalPort());
		return clientSock;
	}
}
