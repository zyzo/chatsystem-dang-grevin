package boundaries.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.User;
/**
 * The 1-on-1 chat window to remote user <br>
 * It allows user to send outgoing/visualize incoming messages and files
 * @author Arthur & Hai An
 *
 *
 */
public class ChatWindow extends JFrame {

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;
	private ChatGUI mChatGUI;
    private User mRemoteUser;

	private JTextArea txtrConversation;
	private JTextArea txtrInputText;
	private JFileChooser fileChooser;

	private JButton btnIncludeImage;

	private JButton btnSend;

	/**
	 * Create the frame.
	 */
	public ChatWindow(ChatGUI chatGUI, User remoteUser) {
		this.mChatGUI = chatGUI;
		this.mRemoteUser = remoteUser;
		addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Fermeture ChatWindow");
            }
        });
		setTitle(remoteUser.getName());
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 3, 478, 190);
		panelConversation.add(scrollPane);
		
		txtrConversation = new JTextArea();
		scrollPane.setViewportView(txtrConversation);
		txtrConversation.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrConversation.setEditable(false);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		panelInput.setBounds(12, 251, 329, 55);
		contentPane.add(panelInput);
		panelInput.setLayout(null);

		txtrInputText = new JTextArea();
		txtrInputText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Sending Stuff..");
		            txtrConversation.append("Moi : "+ txtrInputText.getText()+"\n"+"\r");
		            mChatGUI.performSendMessage(txtrInputText.getText(), mRemoteUser);
		            txtrInputText.setText("");
		            e.consume();
				}
			}
		});
		txtrInputText.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrInputText.setBounds(3, 3, 323, 49);
		panelInput.add(txtrInputText);
		txtrInputText.setLineWrap(true);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	            System.out.println("Sending Stuff..");
	            txtrConversation.append("Moi : "+ txtrInputText.getText()+"\n"+"\r");
	            mChatGUI.performSendMessage(txtrInputText.getText(), mRemoteUser);
	            txtrInputText.setText("");
			}
		});
		btnSend.setBackground(UIManager.getColor("Button.darkShadow"));
		btnSend.setFont(new Font("Arial", Font.BOLD, 16));
		btnSend.setForeground(UIManager.getColor("Button.foreground"));
		btnSend.setBounds(363, 251, 117, 55);
		contentPane.add(btnSend);
		
	
		
		
		btnIncludeImage = new JButton("Send File");
		btnIncludeImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicking Include Image");
				int returnVal = fileChooser.showOpenDialog((Component) e.getSource());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       String fileName = fileChooser.getSelectedFile().getName();
			       System.out.println("You chose to open this file: " +
			            fileName);
			       appendMessage("You are sending " + fileName + " to " + mRemoteUser.getName());
			       mChatGUI.performSendFile(fileChooser.getSelectedFile().getAbsolutePath(), mRemoteUser);
			       appendMessage("File " +  fileName + " is sent");
			    } else if (returnVal == JFileChooser.CANCEL_OPTION) {
			    	System.out.println("Close file chooser window");
			    	fileChooser.cancelSelection();
			    }
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
		//contentPane.add(btnAddParticipant);
		
		fileChooser = new JFileChooser();
		fileChooser.setBounds(0, -44, 517, 326);
	}
	
	  public void appendMessage(String message){
	    	txtrConversation.append(message+"\n"+"\r");
	    	txtrConversation.setCaretPosition(txtrConversation.getDocument().getLength());
	    }

	public void disableWindow() {
		appendMessage(mRemoteUser.getName() + "is disconnected");
		txtrInputText.setEnabled(false);
		btnIncludeImage.setEnabled(false);
		btnSend.setEnabled(true);
	}
	
	public void enableWindow() {
		appendMessage(mRemoteUser.getName() + "reconnects");
		txtrInputText.setEnabled(true);
		btnIncludeImage.setEnabled(true);
		btnSend.setEnabled(true);
	}
}
