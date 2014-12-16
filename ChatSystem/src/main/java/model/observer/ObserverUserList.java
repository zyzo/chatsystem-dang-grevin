package model.observer;

import model.UserList;
import boundaries.swing.ChatGUI;
/**
 * Extends Observer <br>
 * Whe a change happends in the UserList, ObserverUserList react and call the ChatGui in order to update the UserList on the UserListWindow of the User.
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
