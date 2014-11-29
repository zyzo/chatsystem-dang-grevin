package boundaries.swing;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WelcomeWindow extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private JButton buttonConnect;
	private JLabel label;
	private JTextField textNickname ;
	private ChatGUI chatGUI ;
	
	public WelcomeWindow(ChatGUI chatGUI){
		this.chatGUI=chatGUI;
		initComponents();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("CONNEXION "+textNickname.getText());
		chatGUI.performHello();
	}
	
	private void initComponents(){
		label=new JLabel("Enter nickname");
		textNickname = new JTextField(20);
		buttonConnect = new JButton("Connect");
		buttonConnect.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add("West",label);
		this.add("Center",textNickname);
		this.add("East",buttonConnect);
		this.setTitle("Welcome Chat");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	
	public String getUserName(){
		return textNickname.getText();
	}
	
	public JTextField getTextNickname() {
		return textNickname;
	}

}
