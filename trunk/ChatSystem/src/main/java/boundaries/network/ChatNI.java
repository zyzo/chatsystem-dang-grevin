package boundaries.network;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

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
			System.out.println("Socket créé");
			udpSender = new UDPSender(udpsocket,4444);
			udpReceiver = new UDPReceiver(udpsocket,this,4444);
			udpReceiver.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void sendHello() {
        byte[] msg = JSONUtils.constructHello().toString().getBytes();
        try {
			InetAddress address = InetAddress.getByName("localhost");
			udpSender.send(msg, address);
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

	public void receiveMessage(byte[] data) {
		
		JSONObject obj = JSONUtils.byteToJson(data);
		try {
			if(obj.get("type").equals(MessageConstants.TYPE_HELLO)){
				System.out.println("HELLO receive");			
			}
			else if(obj.get("type").equals(MessageConstants.TYPE_HELLO_ACK))
				System.out.println("HELLOACK receive");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
				
	}
	

}
