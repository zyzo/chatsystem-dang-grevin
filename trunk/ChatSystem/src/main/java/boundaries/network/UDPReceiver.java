package boundaries.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver extends Thread {
	
	private DatagramSocket socket;
	private  ChatNI chatNI;
	private int port;

	
	public UDPReceiver(DatagramSocket socket, ChatNI chatNI, int port){
		
		this.socket=socket;
		this.chatNI=chatNI;
		this.port=port;
		
	}
    @Override
    public void run() {
    	byte[] buffer= new byte[1000];
    	DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    	while(true){
    		try {
				socket.receive(packet);
				System.out.println("Received" + new String(packet.getData()));
				
				chatNI.receiveMessage(packet.getData(), packet.getAddress());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
        //TODO
    }

}
