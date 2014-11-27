package controller;


public class ChatController {

    private ChatController() {

    }

    private static ChatController instance;

    public static ChatController getInstance() {
        if (instance == null)
            instance = new ChatController();
        return instance;
    }
}
