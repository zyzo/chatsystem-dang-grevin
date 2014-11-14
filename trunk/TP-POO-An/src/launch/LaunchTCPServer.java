package launch;

import gui.CommunicationWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import net.CommunicaTCPServer;
import net.ListenSocket;

public class LaunchTCPServer implements ILaunch {
	private Socket socket;
	private CommunicationWindow gui;
	
	@Override
	public void run() throws IOException, InterruptedException {
		CommunicaTCPServer server = new CommunicaTCPServer(1234);
		while (true) {
			socket = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			gui = new CommunicationWindow("lebotlan to " + in.readLine(), out, new ListenSocket(in));
		}
	}

	@Override
	public void close() throws IOException {
		gui.close();
		socket.close();
	}
}
