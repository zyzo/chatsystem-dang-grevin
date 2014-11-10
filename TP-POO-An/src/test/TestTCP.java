package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import net.CommunicaTCPServer;

public class TestTCP {
     public static void main(String[] args) throws IOException {
    	 CommunicaTCPServer server = new CommunicaTCPServer(1234);
    	 Socket s = server.accept();
    	 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    	 System.out.println("Message received : " + in.readLine());
     }
}
