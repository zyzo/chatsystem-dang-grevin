package boundaries.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver extends Thread {
	
	private DatagramSocket socket;
	private  ChatNI network;
	private int port;

	
	public UDPReceiver(DatagramSocket socket, ChatNI network, int port){
		
		this.socket=socket;
		this.network=network;
		this.port=port;
		
	}
    @Override
    public void run() {
    	byte[] buffer= new byte[1000];
    	DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    	while(true){
    		try {
				socket.receive(packet);
				System.out.println(packet.getData());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
        //TODO
    }

}
