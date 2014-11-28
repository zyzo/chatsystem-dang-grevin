package boundaries.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {

	private DatagramSocket socket;
	private int port;
	
	public UDPSender(DatagramSocket socket, int port){
		this.socket=socket;
		this.port=port;
	}
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
