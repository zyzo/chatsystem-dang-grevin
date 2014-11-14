package launch;

import gui.CommunicationWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import net.CommunicaTCPClient;
import net.ListenSocket;

public class LaunchTCPClient implements ILaunch {
	private static final String NAME = "acco";

	private Socket socket;
	private CommunicaTCPClient client;
	private CommunicationWindow gui;
	
	@Override
	public void run() throws IOException, InterruptedException {
		client  = new CommunicaTCPClient("localhost", 1234);
		socket = client.getSocket();
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   	 	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
   	 	out.write(NAME);
   	 	out.newLine();
   	 	out.flush();
		gui = new CommunicationWindow(NAME, out, new ListenSocket(in));
	}
	
	@Override
	public void close() throws IOException {
		gui.close();
		socket.close();
	}
	
}
