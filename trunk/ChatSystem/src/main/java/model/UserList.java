package model;
/**
 * 
 * @author Arthur & Hai An
 *
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.observer.Observable;

public class UserList extends Observable{

	private Map<Integer,User> userList;
	private User lastChange;
	
	public UserList(){
		userList = new HashMap<Integer,User>();
	}
	
	public void addUser(User user){
		userList.put(user.getIp().hashCode(), user);
		this.lastChange = user;
		notifyAllObservers();
	}
	
	public void remove(User user){
		this.lastChange = user;
		userList.remove(user.getIp().hashCode());
		notifyAllObservers();
	}
	
	public Map<Integer, User> getUserList() {
		return userList;
	}

	@Override
	public String toString() {
		Collection<User> c = userList.values();
		return c.toString();
	}

	public User getLastChange() {
		return lastChange;
	}
	
	public Collection<User> getUserListCollection(){
		return userList.values();
	}





}
