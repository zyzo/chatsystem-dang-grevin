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
			DatagramSocket udpsocket = new DatagramSocket(1337);
			System.out.println("Socket créé");
			udpSender = new UDPSender(udpsocket,1337);
			udpReceiver = new UDPReceiver(udpsocket,this,1337);
			udpReceiver.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void sendHello() {
        byte[] msg = JSONUtils.constructHello(chatControler.getMe().getName()).toString().getBytes();
        try {
			InetAddress address = InetAddress.getByName("255.255.255.255");
			udpSender.send(msg, address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public void sendHelloAck(InetAddress ip){
    	byte[] msg = JSONUtils.constructHelloAck(chatControler.getMe().getName()).toString().getBytes();
    	udpSender.send(msg,ip);
    }
    
    public void sendGoodBye(){
    	byte[] msg = JSONUtils.constructGoodBye(chatControler.getMe().getName()).toString().getBytes();
    	try {
			udpSender.send(msg, InetAddress.getByName("192.168.0.255"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    private static ChatNI instance;

    public static ChatNI getInstance() {
        if (instance == null)
            instance = new ChatNI();
        return instance;
    }
    


	public void receiveMessage(byte[] data, InetAddress ip) {
		JSONObject obj = JSONUtils.byteToJson(data);
		try {
			if(obj.get("type").equals(MessageConstants.TYPE_HELLO)){
				System.out.println("HELLO receive");
				chatControler.processHello(obj.getString("userName"), ip);
			}
			else if(obj.get("type").equals(MessageConstants.TYPE_HELLO_ACK)){
				System.out.println("HELLOACK receive");
				chatControler.processHelloAck(obj.getString("userName"), ip);
			}
			else if(obj.get("type").equals(MessageConstants.TYPE_GOOD_BYE)){
				System.out.println("GOODBYE receive");
				chatControler.processGoodbye(obj.getString("userName"), ip);
			}
				
		
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
				
	}

	public void setChatControler(ChatController chatControler) {
		this.chatControler = chatControler;
	}
	

}
