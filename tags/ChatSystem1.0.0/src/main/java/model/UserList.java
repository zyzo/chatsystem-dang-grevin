package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.observer.Observable;

/**
 * Model used to represents the list of connected users
 * @author Arthur & Hai An
 *
 */
public class UserList extends Observable{

	private Map<Integer,User> userList;
	
	public UserList(){
		userList = new HashMap<Integer,User>();
	}
	/**
	 * Add a new User to the Map, notify the observer (Patter Observer)<br>
	 * @param user
	 * 		New remote User
	 */
	public void addUser(User user){
		userList.put(user.getIp().hashCode(), user);
		notifyAllObservers();
	}
	
	/**
	 * Remove User to the Map, notify the observer (Pattern Observer)<br>
	 * @param user
	 * 		Remote User 
	 */
	public void remove(User user){
		userList.remove(user.getIp().hashCode());
		notifyAllObservers();
	}
	/**
	 * 
	 * @return UserList
	 */
	
	public Map<Integer, User> getUserList() {
		return userList;
	}

	@Override
	public String toString() {
		Collection<User> c = userList.values();
		return c.toString();
	}
/**
 * 
 * @return UserList (Collection<User>)
 */
	public Collection<User> getUserListCollection(){
		return userList.values();
	}





}
