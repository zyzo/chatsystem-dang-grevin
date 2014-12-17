package boundaries.swing;

import java.awt.EventQueue;

import boundaries.swing.ChatGUI;
import boundaries.swing.UserListWindow;

public class UserListWindowTest {

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
}
