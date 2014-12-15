package boundaries.swing.frame;

import java.awt.EventQueue;

import boundaries.swing.ChatGUI;

public class WelcomeWindowTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeWindow frame = new WelcomeWindow(ChatGUI.getInstance());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
