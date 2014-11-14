package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import launch.MainEntry;
import net.ListenSocket;

public class CommunicationWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final int TEXT_AREA_HEIGHT = 4;
	private static final int TEXT_AREA_WIDTH = 30;
	private static final String SEND_BUTTON_CMD = "SEND_BUTTON";
	private static final String RECEIVE_BUTTON_CMD = "RECEIVE_BUTTON";
	
	private JTextArea sendTextArea;
	private JTextArea receiveMessageTA;
	private JLabel sendMessageLB;
	private JLabel receiveMessageLB;
	private JButton sendButton;
	private JButton receiveButton;
	private BufferedWriter writer;
	private ListenSocket listenSocket;
	private String username;
	
	public CommunicationWindow(String username, BufferedWriter writer, ListenSocket ls) {
		this.writer = new BufferedWriter(writer);
		this.listenSocket = ls;
		this.username = username;
		initComponents();
		this.listenSocket.start();
	}

	private void initComponents() {
		sendTextArea = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		receiveMessageTA = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		sendMessageLB = new JLabel("Message to send");
		receiveMessageLB = new JLabel("Received message");
		sendButton = new JButton("Send");
		sendButton.setActionCommand(SEND_BUTTON_CMD);
		sendButton.addActionListener(this);
		receiveButton = new JButton("Receive");
		receiveButton.setActionCommand(RECEIVE_BUTTON_CMD);
		receiveButton.addActionListener(this);
		this.setLayout(new GridLayout(3,2));
		this.add(sendMessageLB);
		this.add(sendTextArea);
		this.add(sendButton);
		this.add(receiveButton);
		this.add(receiveMessageLB);
		this.add(receiveMessageTA);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.out.println("Active close socket");
				MainEntry.close();
			}
		});
		this.setTitle("Yahoo! Chat " + username);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		if (cmd == SEND_BUTTON_CMD) {
			String msg = sendTextArea.getText();
			try {
				System.out.println("Writing " + msg);
				writer.write(this.username + " : " + msg);
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (cmd == RECEIVE_BUTTON_CMD) { 
			String msg = listenSocket.getLastLine();
			System.out.println("Reading " + msg);
			receiveMessageTA.setText(msg);
		} else { 
			throw new RuntimeException("Action not recognized : " + cmd);
		}
	}

	public void close() throws IOException {
		writer.close();
		listenSocket.close();
		this.setVisible(false);
	}

}
