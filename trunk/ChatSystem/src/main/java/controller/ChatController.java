package controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import boundaries.network.ChatNI;
import boundaries.swing.ChatGUI;
import model.User;
import model.UserList;


public class ChatController {

	private static ChatController instance;
	private ChatNI chatNI = ChatNI.getInstance();
	private ChatGUI chatGUI = ChatGUI.getInstance();
	private UserList userlist = new UserList();
	private User me;
	
	private ChatController() {
		chatNI.setChatControler(this);
		chatGUI.setChatController(this);
		
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
	
	public void processHello(String nickname, InetAddress ip){
		User user = new User(nickname, ip);
		System.out.println(userlist);
		
		if(!(userlist.getUserList().containsKey(user.hashCode()))){
			userlist.getUserList().put(user.hashCode(), user);
			System.out.println(userlist.toString());	
			chatNI.sendHelloAck(user.getIp());
		}
	}
	
	public void processHelloAck(String nickname, InetAddress ip){
		
		User user = new User(nickname,ip);
		userlist.getUserList().put(user.hashCode(), user);
		
		
	}
	
	public void processGoodbye(String nickname,InetAddress ip){
		User user = new User(nickname, ip);
		userlist.getUserList().remove(user.hashCode());
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
    	}
}
