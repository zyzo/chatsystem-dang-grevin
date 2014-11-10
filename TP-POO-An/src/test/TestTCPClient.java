package test;

import gui.CommunicationWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import net.CommunicaTCPClient;

public class TestTCPClient {
	public static void main(String[] args) throws IOException {
		CommunicaTCPClient client  = new CommunicaTCPClient("localhost", 1234);
		Socket s = client.getSocket();
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
   	 	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
   	 	CommunicationWindow gui = new CommunicationWindow("acco", out, in);
	}
}
