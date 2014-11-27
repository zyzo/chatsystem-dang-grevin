package boundaries.swing;



public class ChatGUI {
	
    private ChatGUI() {

    }

    private static ChatGUI instance;

    public static ChatGUI getInstance() {
        if (instance == null)
            instance = new ChatGUI();
        return instance;
    }
    
    public static void main(String[] args) {
    	ChatGUI gui = new ChatGUI();
    	WelcomeWindow welcome= new WelcomeWindow(gui);
    	
      }
}
