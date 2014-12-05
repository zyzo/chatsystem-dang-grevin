package boundaries.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread {
	
	private ServerSocket server;
	
	public TCPServer(int port){
		try {
			server = new ServerSocket(port);
			System.out.println("Lancement serveur TCP");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

    @Override
    public void run() {
    	while(true){
    		try {
				TCPReceiver tcpr = new TCPReceiver(this.server.accept());
				tcpr.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
}
