package entry;

import boundaries.swing.ChatGUI;
import controller.ChatController;

public class MainEntry {
	public static void main(String[] args) {
		ChatController.getInstance();
		ChatGUI.getInstance().promptForUsername();
	}
}
