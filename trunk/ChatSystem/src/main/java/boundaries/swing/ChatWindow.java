package boundaries.swing;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.User;

public class ChatWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final String SEND_BUTTON_TITLE = "Send";
    private static final String SEND_BUTTON_CMD = "Send";

    private ChatGUI chatGUI;
    private User remoteUser;
    private JButton sendButton;

    public ChatWindow(User remoteUser) {
        this.remoteUser = remoteUser;
        this.initComponents();
        chatGUI.getInstance();
    }

    private void initComponents() {
        sendButton = new JButton(SEND_BUTTON_TITLE);
        sendButton.setMargin(new Insets(25, 50, 25, 50));
        sendButton.addActionListener(this);
        sendButton.setActionCommand(SEND_BUTTON_CMD);
        this.setLayout(new FlowLayout());
        this.add(sendButton);
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // TODO : remove the chat window from the map
            }
        });
        this.setTitle(this.remoteUser.getName());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (SEND_BUTTON_CMD.equals(e.getActionCommand())) {
            System.out.println("Sending Stuff..");
            //chatGUI.performSendMessage();
        }
    }

}
