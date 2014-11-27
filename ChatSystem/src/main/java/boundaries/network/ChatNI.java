package boundaries.network;

import java.util.List;

import controller.ChatController;

public class ChatNI {

    private UDPSender udpSender;
    private UDPReceiver udpReceiver;
    private List<TCPSender> tcpSender;
    private List<TCPReceiver> tcpReceiver;
    private TCPServer tcpServer;
    private ChatController chatControler;

    private ChatNI() {

    }

    void sendHello() {
        // TODO
    }

    void processHello() {

    }

    private static ChatNI instance;

    public static ChatNI getInstance() {
        if (instance == null)
            instance = new ChatNI();
        return instance;
    }

}
