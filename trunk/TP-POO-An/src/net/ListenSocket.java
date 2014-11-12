package net;

import java.io.BufferedReader;
import java.io.IOException;

public class ListenSocket extends Thread {
	private BufferedReader reader; 
	private String lastLine;
	
	public ListenSocket(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		try {
			this.lastLine = this.reader.readLine();
		} catch (IOException e) {
			System.out.println(this.getClass().getSimpleName() + ": unable to read from socket");
		}
	}
	
	public String getLastLine() {
		return this.lastLine;
	}
}
