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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.User;

import javax.swing.SwingConstants;

public class ChatWindow extends JFrame implements ActionListener {

   // private static final long serialVersionUID = 1L;

    private static final String SEND_BUTTON_TITLE = "Send";
    private static final String SEND_BUTTON_CMD = "Send";

    private ChatGUI chatGUI = ChatGUI.getInstance();
    private User remoteUser;
    private JButton sendButton;
    private JTextArea textArea;
    private JTextField textField;
    private JPanel panel;

    public ChatWindow(User remoteUser) {
        this.remoteUser = remoteUser;
        this.initComponents();
    }

    private void initComponents() {
    	this.setSize(400,400);
		getContentPane().setLayout(null);
		this.setTitle(remoteUser.toString());
		sendButton = new JButton(SEND_BUTTON_TITLE);
		sendButton.setBounds(323, 211, 101, 40);
		sendButton.setActionCommand(SEND_BUTTON_CMD);
		getContentPane().add(sendButton);
		sendButton.addActionListener(this);
		panel = new JPanel();
		panel.setBounds(10, 0, 414, 210);
		panel.setLayout(new GridLayout(0,1,0,0));
		textArea = new JTextArea();
		getContentPane().add(panel);
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 221, 303, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("FERMETURE");
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
