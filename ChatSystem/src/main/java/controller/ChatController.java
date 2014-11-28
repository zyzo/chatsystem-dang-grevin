package controller;

import boundaries.network.ChatNI;


public class ChatController {

	private static ChatController instance;
	private ChatNI chatNI = ChatNI.getInstance();
	
	
	private ChatController() {
    }


    
    public static ChatController getInstance() {
        if (instance == null)
            instance = new ChatController();
        return instance;
    }

	public void processHello() {
		chatNI.sendHello();
	}
}
