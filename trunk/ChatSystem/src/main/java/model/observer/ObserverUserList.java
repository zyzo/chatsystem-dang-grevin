package model.observer;

import model.UserList;
import boundaries.swing.ChatGUI;

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
