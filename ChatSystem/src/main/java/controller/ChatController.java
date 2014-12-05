package controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import observer.ObserverUserList;
import boundaries.network.ChatNI;
import boundaries.swing.ChatGUI;
import model.User;
import model.UserList;


public class ChatController {

	private static ChatController instance;
	private ChatNI chatNI = ChatNI.getInstance();
	private ChatGUI chatGUI =  ChatGUI.getInstance();
	private UserList userlist = new UserList();
	private User me;
	
	private ChatController() {
		chatNI.setChatControler(this);
		chatGUI.setChatController(this);
		createObserverUserList();
    }
	
	public void createObserverUserList(){
		ObserverUserList observeruserlist = new ObserverUserList(userlist);
	}
	
	


    
    public static ChatController getInstance() {
        if (instance == null)
            instance = new ChatController();
        return instance;
    }

	public void performHello(String nickname) {
		this.setMe(nickname);
		chatNI.sendHello();
	}
	
	public void performGoodbye(){
		chatNI.sendGoodBye();
	}
	
	public void performSendMessage(String message, User user ){
		chatNI.sendMessage(message, user.getIp());
	}
	
	
	public void processHello(String nickname, InetAddress ip){
		User user = new User(nickname, ip);
		System.out.println(userlist);
		
		//if(!(userlist.getUserList().containsKey(user.getIp().hashCode()))){
			userlist.addUser(user);
			System.out.println(userlist.toString());	
			chatNI.sendHelloAck(user.getIp());
		//}
	}
	
	public void receiveMessage(String message, InetAddress ip){
		System.out.println("Reception : " +message);
		chatGUI.displayMessage(message, userlist.getUserList().get(ip.hashCode()));
		
	}
	
	public void processHelloAck(String nickname, InetAddress ip){
		User user = new User(nickname,ip);
		if(!(userlist.getUserList().containsKey(user.getIp().hashCode()))){
			userlist.addUser(user);
		}
		
		
	}
	
	public void processGoodbye(String nickname,InetAddress ip){
		userlist.remove(userlist.getUserList().get(ip.hashCode()));
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
}
