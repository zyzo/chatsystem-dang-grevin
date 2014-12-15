package boundaries.network;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.json.JSONException;
import org.json.JSONObject;

import controller.ChatController;
/**
 * Interface UDP&TCP and ChatController<br>
 * Create UDPSender, UDPReceiver, TCPServeur.
 * @author Arthur & Hai An
 *
 */
public class ChatNI {

    private UDPSender udpSender;
    private UDPReceiver udpReceiver;
    private TCPServer tcpServer;
    private ChatController chatControler;

    private ChatNI() {
    	try {
    		tcpServer = new TCPServer(1337);
    		tcpServer.start();
			DatagramSocket udpsocket = new DatagramSocket(1337);
			System.out.println("Socket créé");
			udpSender = new UDPSender(udpsocket,1337);
			udpReceiver = new UDPReceiver(udpsocket,this,1337);
			udpReceiver.start();
		} catch (SocketException e) {
			System.exit(0);
			e.printStackTrace();
		}
    }
/**
 * Send a Hello Message (JSONObject),use UDP<br>
 */
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
    /**
     * Send a HelloAck message (JSONObject),use UDP <br>
     * @param ip
     * 		ip address of the remote User
     */
    public void sendHelloAck(InetAddress ip){
    	byte[] msg = JSONUtils.constructHelloAck(chatControler.getMe().getName()).toString().getBytes();
    	udpSender.send(msg,ip);
    }
    
    /**
     * Send a Goodbye message (JSONObject),use UDP <br>
     */
    public void sendGoodBye(){
    	byte[] msg = JSONUtils.constructGoodBye(chatControler.getMe().getName()).toString().getBytes();
    	try {
			udpSender.send(msg, InetAddress.getByName("255.255.255.255"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /**
     * Send a HelloAck message (JSONObject), use UDP <br>
     * @param message
     * 		String message we send to the remote User
     * @param ip
     * 		ip address of the remote User
     */
    public void sendMessage(String message, InetAddress ip){
    	byte[] msg = JSONUtils.constructMessage(message).toString().getBytes();
    	udpSender.send(msg,ip);
    }
    
    /**
     * Send a MessageAck message (JSONObject), use UDP <br>
     * @param ip
     * 		ip address of the remote User
     * @param seq
     * 		Sequence number of the message we previously received, we use the same in the MessageAck
     */
    
    public void sendMessageAck(InetAddress ip, int seq){
    	byte[] msg = JSONUtils.constructMessageAck(seq).toString().getBytes();
    	udpSender.send(msg, ip);
    }
    /**
     * Send a File, User TCP<br>
     * @param filePath
     * 		Path of the file we are sending
     * @param ip
     * 		ip address of the Remote User
     */
    public void sendFile(String filePath, InetAddress ip){
    	TCPSender tcps = new TCPSender(filePath, ip, 1337);
    	tcps.start();
    }
    

    private static ChatNI instance;

    public static ChatNI getInstance() {
        if (instance == null)
            instance = new ChatNI();
        return instance;
    }
    
/**
 * Call the ChatController when receiving a message from UDP<br>
 * Different Message to ChatController for the different message receive from UDP
 */
	public void receiveMessage(byte[] data, InetAddress ip) {
		JSONObject obj = JSONUtils.byteToJson(data);
		try {
			if(obj.get("type").equals(MessageConstants.TYPE_HELLO)){
				System.out.println("HELLO receive");
				System.out.println(ip);
				chatControler.processHello(obj.getString("userName"), ip);
			}
			else if(obj.get("type").equals(MessageConstants.TYPE_HELLO_ACK)){
				System.out.println("HELLOACK receive");
				chatControler.processHelloAck(obj.getString("userName"), ip);
			}
			else if(obj.get("type").equals(MessageConstants.TYPE_GOOD_BYE)){
				System.out.println("GOODBYE receive");
				chatControler.processGoodbye(ip);
			}
			else if(obj.get("type").equals(MessageConstants.TYPE_MESSAGE)){
				System.out.println("Message Receive "+ obj.get(MessageConstants.ATT_MESSAGE_DATA).toString());
				chatControler.receiveMessage(obj.get(MessageConstants.ATT_MESSAGE_DATA).toString(), ip, (Integer) obj.get(MessageConstants.ATT_MESSAGE_NUMBER));
			}
				
		
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Call ChatController when received a File
	 */
	public void notifyFileReceived(InetAddress inetAddress, String fileName) {
		chatControler.notifyFileReceived(inetAddress, fileName);
	}
	/**
	 * Call ChatController when receiving a File
	 */
	public void notifyFileReceiving(InetAddress inetAddress, String filename) {
		chatControler.notifyFileReceiving(inetAddress, filename);
	}

	public void setChatControler(ChatController chatControler) {
		this.chatControler = chatControler;
	}

	
}
