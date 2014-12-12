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
    
    public void createChatWindow(User user) {
        chatWindows.put(user, new ChatWindow(this, user));
        chatWindows.get(user).setVisible(true);
    }
    
	public void performHello(String username) {
		welcomeWindow.setVisible(false);
		userListWindow = new UserListWindow(this, username);
		userListWindow.setVisible(true);
		chatController.performHello(username);

	}
	
	public void performSendMessage(String message, User user){
		chatController.performSendMessage(message, user);
	}
	
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
	
	public void setChatController(ChatController chatController) {
		this.chatController = chatController;
	}
	
	public void performGoodBye(){
		chatController.performGoodbye();
	}
	
	
	public void updateList(Collection<User> userlist){
		userListWindow.updateList(userlist);
	}

	public void performSendFile(String filePath, User dstUser) {
		chatController.performSendFile(filePath, dstUser);
		
	}

	public void notifyFileReceiving(User user, String fileName) {
		ChatWindow window = chatWindows.get(user);
		if (window == null) {
			window = chatWindows.put(user, new ChatWindow(this, user));
		}
		window.setVisible(true);
		window.appendMessage(user.getName() + " is sending you a file : " + fileName);
	}

	public void notifyFileReceived(User user, String fileName) {
		ChatWindow window = chatWindows.get(user);
		if (window == null) {
			window = chatWindows.put(user, new ChatWindow(this, user));
		}
		window.setVisible(true);
		chatWindows.get(user).setVisible(true);
		window.appendMessage("File " + fileName + " received");
		
	}

	public void processGoodBye(User user) {
		ChatWindow window;
		if ((window = chatWindows.get(user)) != null) {
			chatWindows.get(user).disableWindow();
		}
	}
	

}
