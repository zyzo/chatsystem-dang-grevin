package boundaries.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.User;

import javax.swing.SwingConstants;

public class ChatWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final String SEND_BUTTON_TITLE = "Send";
    private static final String SEND_BUTTON_CMD = "Send";

    private ChatGUI chatGUI = ChatGUI.getInstance();
    private User remoteUser;
    private JButton sendButton;
    private JTextArea textArea;
    private JTextField textField;

    public ChatWindow(User remoteUser) {
        this.remoteUser = remoteUser;
        this.initComponents();
    }

    private void initComponents() {
		getContentPane().setLayout(null);
		this.setTitle(remoteUser.toString());
		sendButton = new JButton(SEND_BUTTON_TITLE);
		sendButton.setBounds(323, 211, 101, 40);
		sendButton.setActionCommand(SEND_BUTTON_CMD);
		getContentPane().add(sendButton);
		sendButton.addActionListener(this);
		textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 210);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 221, 303, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
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
            textArea.append("Moi : "+textField.getText()+"\n"+"\r");
            chatGUI.performSendMessage(textField.getText(), remoteUser);
            //chatGUI.performSendMessage();
        }
    }
    

}
