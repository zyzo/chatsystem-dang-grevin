package boundaries.swing.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import boundaries.swing.ChatGUI;
import model.User;

public class UserListWindow extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<User> dlm= new DefaultListModel<User>();
	private ChatGUI mChatGUI;
	private JList<User> list;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserListWindow frame = new UserListWindow(ChatGUI.getInstance(), "hoho");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UserListWindow(ChatGUI chatGUI, String username) {
		this.mChatGUI = chatGUI;
		setTitle("ChatSystem");
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel userInfo = new JPanel();
		userInfo.setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		userInfo.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new MatteBorder(1, 1, 1, 1, (Color) new Color(64, 64, 64))));
		userInfo.setBounds(0, 0, 362, 111);
		contentPane.add(userInfo);
		userInfo.setLayout(null);
		
		JLabel lblWel = new JLabel("Welcome back, " + username);
		lblWel.setFont(new Font("Arial", Font.BOLD, 14));
		lblWel.setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		lblWel.setBounds(12, 30, 194, 15);
		userInfo.add(lblWel);
		
		JPanel userList = new JPanel();
		userList.setBorder(null);
		userList.setBounds(0, 110, 362, 509);
		contentPane.add(userList);
		userList.setLayout(null);
		
		list = new JList<User>(dlm);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2){
					System.out.println("CREATION CHATWINDOW with " + list.getSelectedValue().getName());
					mChatGUI.createChatWindow(list.getSelectedValue());
				}
			}
		});
		list.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		list.setBounds(0, 0, 362, 469);
		userList.add(list);
		
		JLabel lblAuthorsA = new JLabel("Authors : A & A");
		lblAuthorsA.setFont(new Font("Arial", Font.BOLD, 12));
		lblAuthorsA.setBounds(25, 476, 155, 15);
		userList.add(lblAuthorsA);
		
		JLabel lblAllRightsNot_1 = new JLabel("All rights not reserved - Toulouse 2014");
		lblAllRightsNot_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblAllRightsNot_1.setBounds(25, 492, 230, 15);
		userList.add(lblAllRightsNot_1);
	}
	
	public void updateList(Collection<User> userlist){
		dlm.removeAllElements();
		for(User user: userlist){
			dlm.addElement(user);;
		}
		
	}
	
}
