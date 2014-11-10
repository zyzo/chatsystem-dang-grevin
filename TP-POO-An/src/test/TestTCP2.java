package test;

import java.io.IOException;

import net.CommunicaTCPClient;

public class TestTCP2 {
	public static void main(String[] args) {
		CommunicaTCPClient client  = new CommunicaTCPClient("localhost", 1234);
   	 try {
			client.sendMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
