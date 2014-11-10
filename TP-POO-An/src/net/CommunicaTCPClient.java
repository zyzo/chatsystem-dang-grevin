package net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicaTCPClient {
	private Socket sock;
	
	public CommunicaTCPClient(String host, int portNumber) {
		try {
			sock = new Socket(host, portNumber);
		} catch (UnknownHostException e1) {
			System.err.println("Host not recognized : " + host);
			System.exit(-1);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
	}

	public Socket getSocket() {
		return sock;
	}
}
