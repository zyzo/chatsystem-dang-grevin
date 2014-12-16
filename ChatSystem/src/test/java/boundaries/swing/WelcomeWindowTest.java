package boundaries.swing;

import java.awt.EventQueue;

import boundaries.swing.ChatGUI;
import boundaries.swing.WelcomeWindow;

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
