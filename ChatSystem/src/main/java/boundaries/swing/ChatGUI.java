package boundaries.swing;

import java.util.HashMap;
import java.util.Map;

import pattern.observer.Observer;
import controller.ChatController;
import model.User;
import model.UserList;

public class ChatGUI  extends Observer {

    private Map<User, ChatWindow> chatWindows;
    private WelcomeWindow welcome;
    private UserListWindow usersListwindow;
    private UserListWindowbuilder ulwb;
    private ChatController chatController;
	private static ChatGUI instance;

    private ChatGUI(UserList model){
    	this.ul = model;
    	this.ul.attach(this);
    	chatWindows = new HashMap<User, ChatWindow>();
    	welcome = new WelcomeWindow(this);
    }
    

    public static ChatGUI getInstance(UserList model) {
        if (instance == null)
            instance = new ChatGUI (model);
        return instance;
    }
    
    protected void createChatWindow(User user) {
        chatWindows.put(user, new ChatWindow(user));
    }
    
    public String getUserName(){
    	return welcome.getUserName();
    }
    
	protected void performHello() {
		//System.out.println(welcome.getTextNickname().getText());
		String nom ="";
		nom = welcome.getTextNickname().getText();
		welcome.setVisible(false);
		this.ulwb= new UserListWindowbuilder(this);
		chatController.performHello(nom);

	}
	
	public void setChatController(ChatController chatController) {
		this.chatController = chatController;
	}
	
	public void update(){
		this.ulwb.addUser(ul.getLastChange());
	}

}
