package boundaries.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * UDPSender is the Class who send DatagramPacket to the remote User
 * 
 * @author Arthur & Hai An
 *
 */
public class UDPSender {

	private DatagramSocket socket;
	private int port;
	
	public UDPSender(DatagramSocket socket, int port){
		this.socket=socket;
		this.port=port;
	}
	/**
	 * Build the DatagramPacket, and send it, Print it on the console
	 * @param buffer
	 * 		Contains the object that will be send to the remote User
	 * @param address
	 * 		Ip Address of the Remote User
	 */
	public void send(byte[] buffer,InetAddress address){
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address,port);
		try {
			socket.send(packet);
			System.out.println("Envoi de " + new String(buffer));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
