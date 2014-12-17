package boundaries.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * UDPReceiver is the receiving entity of incoming UDP packets
 * On <code>start()</code>, the thread will start waiting for incoming UDP packets
 * @author Arthur & Hai An
 */
public class UDPReceiver extends Thread {
	
	private DatagramSocket socket;
	private  ChatNI chatNI;
	
	/**
	 * 
	 * @param socket
	 * 		socket for receiving incoming DatagramPackets
	 * @param chatNI
	 * 	    instance of ChatNI facade
	 * @param port
	 *      port to listen to incoming DatagramPackets
	 */
	public UDPReceiver(DatagramSocket socket, ChatNI chatNI, int port){
		this.socket=socket;
		this.chatNI=chatNI;
	}
    /**
     * Always waiting for incoming packets <br>
     * When receiving a packet, it will pass the packet to ChatNI for further processing
     */
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
