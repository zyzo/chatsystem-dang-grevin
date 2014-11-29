package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pattern.observer.Observable;

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




}
