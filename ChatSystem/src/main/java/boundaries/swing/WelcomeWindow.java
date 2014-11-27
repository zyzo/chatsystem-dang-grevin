package boundaries.swing;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WelcomeWindow extends JFrame implements ActionListener{
	
	private JButton buttonConnect;
	private JLabel label;
	private JTextField textNickname;
	private ChatGUI gui;
	
	public WelcomeWindow(ChatGUI gui){
		this.gui= gui;
		initComponents();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("CONNEXION "+textNickname.getText());
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
	

}
