package boundaries.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Create SocketServer use in order to send and receiver File<br>
 * Extends Thread, always running to check if new Connection can be accept in the ServerSocket
 * @author Arthur & Hai An
 *
 */
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
/**
 * When the server accept a new connection, call TCPReceiver that will receive the Data
 * 
 */
    public void run() {
    	while(true){
    		try {
				TCPReceiver tcpr = new TCPReceiver(this.server.accept());
				System.out.println("Accept OK");
				tcpr.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
}
