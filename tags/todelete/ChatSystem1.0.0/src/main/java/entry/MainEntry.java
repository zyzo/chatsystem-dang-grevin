package entry;

import boundaries.swing.ChatGUI;
import controller.ChatController;

/**
 * Entry point of the system
 * @author Arthur & Hai An
 *
 */
public class MainEntry {
	public static void main(String[] args) {
		ChatController.getInstance();
		ChatGUI.getInstance().promptForUsername();
	}
}
