package boundaries.swing;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

import model.User;

public class UserListWindowbuilder extends JFrame implements MouseListener{
		
		private JList<User> list;
		private JLabel lab;
		private DefaultListModel<User> dlm= new DefaultListModel<User>();
		private ChatGUI chatgui;
	 	
	public UserListWindowbuilder(ChatGUI chatgui) {
		this.chatgui=chatgui;
		initComponents();
	}
	

	
	public void initComponents(){
		this.setLayout(new BorderLayout(0, 0));
		
		list = new JList<User>(dlm);
		list.addMouseListener(this);
		this.add(list, BorderLayout.CENTER);
		
		lab = new JLabel("USER LIST");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lab, BorderLayout.NORTH);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void addUser(User user){
		dlm.addElement(user);
		this.pack();
		}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			System.out.println("CREATION CHATWINDOW");
		}
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
}
