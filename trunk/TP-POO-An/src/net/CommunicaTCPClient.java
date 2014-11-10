package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicaTCPClient {
	Socket sock;
	BufferedWriter out;
	
	public CommunicaTCPClient(String host, int portNumber) {
		try {
			sock = new Socket(host, portNumber);
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		} catch (UnknownHostException e1) {
			System.err.println("Host not recognized : " + host);
			System.exit(-1);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
	}
	public void sendMessage() throws IOException {
		BufferedReader stdIn =  new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		System.out.print("Your message to send : ");
		while ((userInput = stdIn.readLine()) != null) {
			System.out.println("Sending : " + userInput);
			out.write(userInput.toCharArray());
			out.newLine();
			out.flush();
			System.out.println("Message sent.");
		}
		
 	}
}
