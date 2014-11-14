package launch;

import java.io.IOException;
import java.util.Scanner;

public class MainEntry {
	
	public static ILaunch l;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner s = new Scanner(System.in);
		System.out.print("Start app as :\n 1. Client\n 2. Server\nYour choice ? ");
		int choice = s.nextInt();
		s.close();
		if (choice == 1) {
			l = new LaunchTCPClient();
			l.run();
		} else if (choice == 2) {
			l = new LaunchTCPServer();
			l.run();
		}
	}
	
	public static void close() {
		try {
			l.close();
		} catch (IOException e) {
			System.out.println("Wtf?");
			e.printStackTrace();
		}
	}
}
