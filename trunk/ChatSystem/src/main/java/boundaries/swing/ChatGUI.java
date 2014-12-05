package boundaries.swing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controller.ChatController;
import model.User;

public class ChatGUI{

    private Map<User, ChatWindow> chatWindows;
    private WelcomeWindow welcome;
    private UserListWindow usersListwindow;
    private UserListWindowbuilder ulwb;
    private ChatController chatController;
	private static ChatGUI instance;

    private ChatGUI(){
    	chatWindows = new HashMap<User, ChatWindow>();
    	welcome = new WelcomeWindow(this);
    }
    

    public static ChatGUI getInstance() {
        if (instance == null)
            instance = new ChatGUI ();
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
	
	protected void performSendMessage(String message, User user){
		chatController.performSendMessage(message, user);
	}
	
	public void displayMessage(String message, User user){
		try{
			chatWindows.get(user).setVisible(true);
			chatWindows.get(user).appendMessage(user.getName()+" : " +message);
		}catch (java.lang.NullPointerException e){
			chatWindows.put(user, new ChatWindow(user));
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
		ulwb.updateList(userlist);
	}
	

}
