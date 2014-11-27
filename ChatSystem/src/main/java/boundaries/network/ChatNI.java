package boundaries.network;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import controller.ChatController;

public class ChatNI {

    private UDPSender udpSender;
    private UDPReceiver udpReceiver;
    private List<TCPSender> tcpSender;
    private List<TCPReceiver> tcpReceiver;
    private TCPServer tcpServer;
    private ChatController chatControler;

    private ChatNI() {
    	try {
			DatagramSocket udpsocket = new DatagramSocket(4444);
			System.out.println("Socket crée");
			udpSender = new UDPSender(udpsocket,4444);
			udpReceiver = new UDPReceiver(udpsocket,this,4444);
			udpReceiver.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    void sendHello() {
        byte[] buffer = "HELLO".getBytes();
        try {
			InetAddress address = InetAddress.getByName("localhost");
			udpSender.send(buffer, address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    void processHello() {

    }

    private static ChatNI instance;

    public static ChatNI getInstance() {
        if (instance == null)
            instance = new ChatNI();
        return instance;
    }
    
    public static void main(String[] args){
    	ChatNI.getInstance().sendHello();
    	
    }

}
