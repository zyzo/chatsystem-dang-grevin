package boundaries.swing.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.UIManager;

public class ChatWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatWindow frame = new ChatWindow();
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
	public ChatWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelConversation = new JPanel();
		panelConversation.setBorder(new LineBorder(new Color(0, 128, 128), 3, true));
		panelConversation.setBounds(12, 12, 484, 196);
		contentPane.add(panelConversation);
		panelConversation.setLayout(null);
		
		JTextArea txtrConversation = new JTextArea();
		txtrConversation.setBounds(3, 3, 478, 190);
		panelConversation.add(txtrConversation);
		txtrConversation.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrConversation.setText("sad");
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicking Send");
			}
		});
		btnSend.setBackground(UIManager.getColor("Button.darkShadow"));
		btnSend.setFont(new Font("Arial", Font.BOLD, 16));
		btnSend.setForeground(UIManager.getColor("Button.foreground"));
		btnSend.setBounds(363, 251, 117, 55);
		contentPane.add(btnSend);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		panelInput.setBounds(12, 251, 329, 55);
		contentPane.add(panelInput);
		panelInput.setLayout(null);
		
		JTextArea txtrInputText = new JTextArea();
		txtrInputText.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrInputText.setBounds(3, 3, 323, 49);
		panelInput.add(txtrInputText);
		txtrInputText.setLineWrap(true);
		txtrInputText.setText("input text");
		
		JButton btnIncludeImage = new JButton("Include Image");
		btnIncludeImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicking Include Image");
			}
		});
		btnIncludeImage.setForeground(UIManager.getColor("Button.foreground"));
		btnIncludeImage.setBackground(UIManager.getColor("Button.darkShadow"));
		btnIncludeImage.setFont(new Font("Arial", Font.BOLD, 12));
		btnIncludeImage.setBounds(363, 220, 117, 25);
		contentPane.add(btnIncludeImage);
		
		JButton btnAddParticipant = new JButton("Add participant");
		btnAddParticipant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicking Add Participant");
			}
		});
		btnAddParticipant.setForeground(UIManager.getColor("Button.foreground"));
		btnAddParticipant.setBackground(UIManager.getColor("Button.darkShadow"));
		btnAddParticipant.setFont(new Font("Arial", Font.BOLD, 12));
		btnAddParticipant.setBounds(12, 220, 160, 25);
		contentPane.add(btnAddParticipant);
		
	}
}
