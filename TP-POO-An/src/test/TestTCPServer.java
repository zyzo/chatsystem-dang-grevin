package test;

import gui.CommunicationWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import net.CommunicaTCPServer;

public class TestTCPServer {
	public static void main(String[] args) throws IOException {
		CommunicaTCPServer server = new CommunicaTCPServer(1234);
		while (true) {
			Socket s = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			CommunicationWindow gui = new CommunicationWindow("lebotlan to " + in.readLine(), out, in);
		}
	}
}
