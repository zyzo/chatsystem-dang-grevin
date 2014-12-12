package boundaries.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * 
 * @author Arthur & Hai An
 *
 */
public class UDPReceiver extends Thread {
	
	private DatagramSocket socket;
	private  ChatNI chatNI;
	public UDPReceiver(DatagramSocket socket, ChatNI chatNI, int port){
		
		this.socket=socket;
		this.chatNI=chatNI;
		
	}
    @Override
    public void run() {
    	byte[] buffer= new byte[1000];
    	DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    	while(true){
    		try {
				socket.receive(packet);
				System.out.println("Received" + new String(packet.getData()));
				System.out.println("from" + packet.getAddress());
				
				chatNI.receiveMessage(packet.getData(), packet.getAddress());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
        //TODO
    }

}
