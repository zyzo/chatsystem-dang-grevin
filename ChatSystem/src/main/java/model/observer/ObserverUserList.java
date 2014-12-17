package model.observer;

import model.UserList;
import boundaries.swing.ChatGUI;
/**
 * Linker between the UserList model and the display users list via GUI <br>
 * When a change happens in the <code>UserList</code>, <code>ObserverUserList</code> gets notified and <br>
 * calls updateList() on <code>ChatGUI</code>
 * @author Arthur & Hai An
 *
 */
public class ObserverUserList extends Observer{
	
	public ObserverUserList(UserList userlist){
		this.ul=userlist;
		ul.attach(this);
	}

	@Override
	public void update() {
		ChatGUI.getInstance().updateList(ul.getUserListCollection());
	}

}
