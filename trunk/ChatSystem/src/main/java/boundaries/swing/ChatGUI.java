package boundaries.swing;

import java.util.HashMap;
import java.util.Map;

import controller.ChatController;

import model.User;

public class ChatGUI {

    private Map<User, ChatWindow> chatWindows;
    private WelcomeWindow welcome;
    private UserListWindow usersListwindow;
    private ChatController chatController;
    
    private ChatGUI() {
    	chatWindows = new HashMap<User, ChatWindow>();
    	welcome = new WelcomeWindow(this);
    }
    
	private static ChatGUI instance;

    public static ChatGUI getInstance() {
        if (instance == null)
            instance = new ChatGUI();
        return instance;
    }
    
    protected void createChatWindow(User user) {
        chatWindows.put(user, new ChatWindow(user));
    }
    
    public String getUserName(){
    	return welcome.getUserName();
    }
    
	protected void processHello() {
		//System.out.println(welcome.getTextNickname().getText());
		String nom ="";
		nom = welcome.getTextNickname().getText();
		chatController.performHello(nom);
		welcome.setVisible(false);
		usersListwindow = new UserListWindow();
	}

	public void setChatController(ChatController chatController) {
		this.chatController = chatController;
	}

}
