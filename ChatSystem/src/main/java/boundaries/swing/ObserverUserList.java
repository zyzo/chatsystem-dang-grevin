package boundaries.swing;

import model.UserList;
import boundaries.network.ChatNI;
import pattern.observer.Observer;

public class ObserverUserList extends Observer{
	
	public ObserverUserList(UserList userlist){
		this.ul=userlist;
		ul.attach(this);
	}

	@Override
	public void update() {
		ChatGUI.getInstance().addUser(ul.getLastChange());
	}

}
