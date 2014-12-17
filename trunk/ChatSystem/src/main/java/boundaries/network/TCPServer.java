package boundaries.network;

import java.io.IOException;
import java.net.ServerSocket;
/**
 * TCPServer is the listener of incoming TCP connection establishment requests.
 * On <code>start()</code>, TCPServer runs continuously
 * to check if a new TCP connection request arrives
 * @author Arthur & Hai An
 *
 */
public class TCPServer extends Thread {
	
	private ServerSocket server;
	
	/**
	 * 
	 * @param port
	 * 		port to listen to
	 */
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
	 * When the server accept a new connection, 
	 * create a new TCPReceiver that will receive the Data
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
