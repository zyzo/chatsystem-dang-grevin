package net;

import java.io.BufferedReader;
import java.io.IOException;

import launch.MainEntry;

public class ListenSocket extends Thread {
	private BufferedReader reader; 
	private String lastLine;
	
	public ListenSocket(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		this.lastLine = " ";
		while (true && (lastLine != null)) {
		System.out.println("ListenSocket!!");
		try {
			this.lastLine = this.reader.readLine();
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + ": unable to read from socket");
			System.out.println("Passive close socket");
			MainEntry.close();
			System.exit(-1);
		}
		}
	}
	
	public String getLastLine() {
		return this.lastLine;
	}
	
	public void close() throws IOException {
		this.reader.close();
	}
}
