package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CommunicationWindow extends JFrame {

	private static final int TEXT_AREA_HEIGHT = 4;

	private static final int TEXT_AREA_WIDTH = 30;

	private static final long serialVersionUID = 1L;
	
	private JTextArea sendMessageTA;
	private JTextArea receiveMessageTA;
	private JLabel sendMessageLB;
	private JLabel receiveMessageLB;
	private JButton sendButton;
	private JButton receiveButton;
	private GridBagConstraints c;
	
	public CommunicationWindow(BufferedWriter writer, BufferedReader reader) {
		initComponents();
	}

	private void initComponents() {
		sendMessageTA = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		receiveMessageTA = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		sendMessageLB = new JLabel("Message to send");
		receiveMessageLB = new JLabel("Received message");
		sendButton = new JButton("Send");
		receiveButton = new JButton("Receive");
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(10,10,10,10);
		c.fill = GridBagConstraints.BOTH;
		this.addComponent(sendMessageLB, 0, 0);
		this.addComponent(sendMessageTA, 0, 1);
		this.addComponent(sendButton, 1, 0);
		this.addComponent(receiveButton, 1, 1);
		this.addComponent(receiveMessageLB, 2, 0);
		this.addComponent(receiveMessageTA, 2, 1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Yahoo! Chat");
		this.pack();
		this.setVisible(true);
	}
	
	private void addComponent(Component comp, int x, int y) {
		c.gridx = y;
		c.gridy = x;
		this.add(comp, c);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		CommunicationWindow w = new CommunicationWindow(null, null);
	}
}
