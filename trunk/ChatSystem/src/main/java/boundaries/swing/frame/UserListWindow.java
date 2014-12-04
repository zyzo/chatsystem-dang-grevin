package boundaries.swing.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserListWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserListWindow frame = new UserListWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserListWindow() {
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
		
		JLabel lblWel = new JLabel("Welcome back, $NAME$");
		lblWel.setFont(new Font("Arial", Font.BOLD, 14));
		lblWel.setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		lblWel.setBounds(12, 30, 194, 15);
		userInfo.add(lblWel);
		
		JPanel userList = new JPanel();
		userList.setBorder(null);
		userList.setBounds(0, 110, 362, 509);
		contentPane.add(userList);
		userList.setLayout(null);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicking on list");
			}
		});
		list.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Mummy", "Frankenstein", "Dracular", "Arthur"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
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
}
