package controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import model.User;
import model.UserList;
import model.observer.ObserverUserList;
import boundaries.network.ChatNI;
import boundaries.swing.ChatGUI;

/**
 * 
 *ChatSystem Controller<br>
 *Link between ChatNI and ChatGUI<br>
 *Update UserList in Model<br>
 * @author Arthur & Hai An<br>
 *
 *
 *
 */
public class ChatController {

	private static ChatController instance;
	private ChatNI chatNI = ChatNI.getInstance();
	private ChatGUI chatGUI =  ChatGUI.getInstance();
	private UserList userlist = new UserList();
	private User me;
	
	private ChatController() {
		chatNI.setChatControler(this);
		chatGUI.setChatController(this);
		new ObserverUserList(userlist);
    }
	
    public static ChatController getInstance() {
        if (instance == null)
            instance = new ChatController();
        return instance;
    }

/**
 * 
 * @param nickname
 * Nickname of the user of this ChatSystem
 *
 */
	public void performHello(String nickname) {
		this.setMe(nickname);
		chatNI.sendHello();
	}
/**
 * Call ChatNI in order to send Goodbye
 * 
 */
	public void performGoodbye(){
		chatNI.sendGoodBye();
	}
/**
 * 
 * @param message
 * 		Message user want to send
 * @param user
 * 		Remote user
 */
	
	public void performSendMessage(String message, User user ){
		chatNI.sendMessage(message, user.getIp());
	}
	
	/**
	 * 
	 * @param nickname
	 * 		nickname of the remote User
	 * @param ip
	 * 		ip of the remote User
	 * 
	 * Add a new User to the UserList
	 * 
	 */
	public void processHello(String nickname, InetAddress ip){
		User user = new User(nickname, ip);
		System.out.println(userlist);
		
			userlist.addUser(user);
			System.out.println(userlist.toString());	
			chatNI.sendHelloAck(user.getIp());
	}
	/**
	 * 
	 * @param message
	 * 		message receive from the remote user
	 * @param ip
	 * 		address ip from the remote user
	 * @param seq
	 * 		numero de séquence du message
	 * 
	 * Call ChatNI in order to send a MessageAck to the remote User.
	 * 
	 */
	public void receiveMessage(String message, InetAddress ip,  int seq){
		System.out.println("Reception : " +message);
		chatNI.sendMessageAck(ip,seq);
		chatGUI.displayMessage(message, userlist.getUserList().get(ip.hashCode()));
		
	}
	
	/**
	 * 
	 * @param nickname
	 * @param ip
	 */
	public void processHelloAck(String nickname, InetAddress ip){
		User user = new User(nickname,ip);
		if(!(userlist.getUserList().containsKey(user.getIp().hashCode()))){
			userlist.addUser(user);
		}
		
		
	}
	
	public void processGoodbye(InetAddress ip){
		User existingUser = userlist.getUserList().get(ip.hashCode());
		if (existingUser != null) {
			userlist.remove(existingUser);
			chatGUI.processGoodBye(userlist.getUserList().get(ip.hashCode()));
		}
	}
	
	public void performSendFile(String filepath, User user){
		chatNI.sendFile(filepath, user.getIp());
	}



	public User getMe() {
		return me;
	}

	public void setMe(String mename) {
		try {
			User user = new User(mename,InetAddress.getByName("localhost"));
			this.me=user;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
    public static void main(String[] args) {
    	ChatController.getInstance(); 
    	ChatGUI.getInstance().promptForUsername();
    }

	public void notifyFileReceived(InetAddress inetAddress, String fileName) {
		chatGUI.notifyFileReceived(userlist.getUserList().get(inetAddress.hashCode()), fileName);
	}

	public void notifyFileReceiving(InetAddress inetAddress, String fileName) {
		chatGUI.notifyFileReceiving(userlist.getUserList().get(inetAddress.hashCode()), fileName);
		
	}
}
