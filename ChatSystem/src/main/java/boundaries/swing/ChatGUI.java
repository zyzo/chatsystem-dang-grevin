package boundaries.swing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.User;
import boundaries.swing.frame.ChatWindow;
import boundaries.swing.frame.UserListWindow;
import boundaries.swing.frame.WelcomeWindow;
import controller.ChatController;
/**
 * 
 * @author Arthur & Hai An
 *
 *
 *Interface between the Windows, and the Controller. <br>
 *
 *Create the WelcomeWindow, the Userlist and the chat windows
 *
 */
public class ChatGUI{

    private Map<User, ChatWindow> chatWindows;
    private WelcomeWindow welcomeWindow;
    private UserListWindow userListWindow;
    private ChatController chatController;
	private static ChatGUI instance;

    private ChatGUI(){
    	chatWindows = new HashMap<User, ChatWindow>();
    }
    
    public void promptForUsername() {
    	welcomeWindow = new WelcomeWindow(this);
    	welcomeWindow.setVisible(true);
    }
    

    public static ChatGUI getInstance() {
        if (instance == null)
            instance = new ChatGUI ();
        return instance;
    }
    
    /**
     * Link a ChatWindow to a User in a Map<User,ChatWindow>
     * @param user
     * 		Remote User
     */
    public void createChatWindow(User user) {
        chatWindows.put(user, new ChatWindow(this, user));
        chatWindows.get(user).setVisible(true);
    }
    /**
     * Call ChatController and display the UserListWindow
     * @param username
     * 		Nickname of the User of this ChatSystem
     */
	public void performHello(String username) {
		welcomeWindow.setVisible(false);
		userListWindow = new UserListWindow(this, username);
		userListWindow.setVisible(true);
		chatController.performHello(username);

	}
	/**
	 * Call ChatController in order to send the message to the remote User
	 * @param message
	 * 		message from the user of this ChatSystem
	 * @param user
	 * 		Remote User
	 */
	public void performSendMessage(String message, User user){
		chatController.performSendMessage(message, user);
	}
	
	/**
	 * display the new message to the right chatWindow. <br>
	 * If the ChatWindow is not create, Create it
	 * 
	 * @param message
	 * 		message from the remote User
	 * @param user
	 * 		Remote User
	 */
	public void displayMessage(String message, User user){
		try{
			chatWindows.get(user).setVisible(true);
			chatWindows.get(user).appendMessage(user.getName()+" : " +message);
		}catch (java.lang.NullPointerException e){
			chatWindows.put(user, new ChatWindow(this, user));
			chatWindows.get(user).setVisible(true);
			chatWindows.get(user).appendMessage(user.getName()+" : " +message);
		}
	}
	/**
	 * Use to link ChatGui to Chatcontroller
	 * @param chatController
	 *		
	 */
	public void setChatController(ChatController chatController) {
		this.chatController = chatController;
	}
	/**
	 * Call ChatController to send Goodbye
	 */
	public void performGoodBye(){
		chatController.performGoodbye();
	}
	
	/**
	 * Call userListWindow to update the UserList
	 * @param userlist
	 * 		Collection of User
	 */
	public void updateList(Collection<User> userlist){
		userListWindow.updateList(userlist);
	}
	/**
	 * Call ChatController in order to send a file
	 * @param filePath
	 * 		Path of the file we choose to send
	 * @param dstUser
	 * 		Remote User
	 */
	public void performSendFile(String filePath, User dstUser) {
		chatController.performSendFile(filePath, dstUser);
		
	}
/**
 * Notify the User, in the ChatWindow, that we are receiving a file from a remote User<br>
 * @param user
 * 		remote User
 * @param fileName
 * 		Name of the file we are receiving
 */
	public void notifyFileReceiving(User user, String fileName) {
		ChatWindow window = chatWindows.get(user);
		if (window == null) {
			window = chatWindows.put(user, new ChatWindow(this, user));
		}
		window.setVisible(true);
		window.appendMessage(user.getName() + " is sending you a file : " + fileName);
	}
/**
 * Notify the User, in the ChatWindow, that we finished receive a file from a remote User<br>
 * @param user
 * 		remote User
 * @param fileName
 * 		Name of the file we received
 */
	public void notifyFileReceived(User user, String fileName) {
		ChatWindow window = chatWindows.get(user);
		if (window == null) {
			window = chatWindows.put(user, new ChatWindow(this, user));
		}
		window.setVisible(true);
		chatWindows.get(user).setVisible(true);
		window.appendMessage("File " + fileName + " received");
		
	}
/**
 * If a ChatWindow is open from a remote User, and a Goodbye from the remote User is received then we close it.
 * @param user
 * 		Remote User
 */
	public void processGoodBye(User user) {
		ChatWindow window;
		if ((window = chatWindows.get(user)) != null) {
			chatWindows.get(user).disableWindow();
		}
	}
	

}
