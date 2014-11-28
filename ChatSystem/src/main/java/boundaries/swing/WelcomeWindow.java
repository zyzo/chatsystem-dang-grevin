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
	private JTextField textNickname;
	private ChatGUI chatGUI = ChatGUI.getInstance();
	
	public WelcomeWindow(){
		initComponents();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("CONNEXION "+textNickname.getText());
		chatGUI.processHello();
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
		this.pack();
		this.setVisible(true);
		
	}
	
	public String getUserName(){
		return textNickname.getText();
	}
	

}
