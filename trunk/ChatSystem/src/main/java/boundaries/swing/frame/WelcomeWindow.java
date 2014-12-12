package boundaries.swing.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import boundaries.swing.ChatGUI;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 
 * @author Arthur & Hai An
 *
 */
public class WelcomeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblYourNickname;
	private ChatGUI mChatGUI;

	/**
	 * Create the frame.
	 */
	public WelcomeWindow(ChatGUI chatGUI) {
		this.mChatGUI = chatGUI;
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		setFont(new Font("Andale Mono", Font.BOLD, 17));
		setTitle("ChatSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 168);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("List.dropLineColor"));
		contentPane.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Your nickname " + textField.getText());
					mChatGUI.performHello(textField.getText());
				}
			}
		});
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textField.setBounds(166, 54, 141, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblWelcomeToappname = new JLabel("ChatSystem v1.0");
		lblWelcomeToappname.setFont(new Font("Arial", Font.BOLD, 16));
		lblWelcomeToappname.setForeground(SystemColor.activeCaptionText);
		lblWelcomeToappname.setBounds(108, 12, 134, 15);
		contentPane.add(lblWelcomeToappname);
		
		lblYourNickname = new JLabel("Your nickname");
		lblYourNickname.setFont(new Font("Arial", Font.BOLD, 15));
		lblYourNickname.setForeground(SystemColor.activeCaptionText);
		lblYourNickname.setBounds(31, 59, 124, 15);
		contentPane.add(lblYourNickname);
		
		JButton btnLetsChat = new JButton("Let's chat");
		btnLetsChat.setForeground(SystemColor.activeCaptionText);
		btnLetsChat.setFont(new Font("Arial", Font.BOLD, 15));
		btnLetsChat.setBackground(UIManager.getColor("TextField.inactiveForeground"));
		btnLetsChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Your nickname " + textField.getText());
				mChatGUI.performHello(textField.getText());
			}
		});
		btnLetsChat.setBounds(190, 100, 117, 25);
		contentPane.add(btnLetsChat);
	}
}
