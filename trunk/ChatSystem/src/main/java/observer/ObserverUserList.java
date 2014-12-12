package observer;

import model.UserList;
import boundaries.network.ChatNI;
import boundaries.swing.ChatGUI;
import pattern.observer.Observer;
/**
 * 
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
