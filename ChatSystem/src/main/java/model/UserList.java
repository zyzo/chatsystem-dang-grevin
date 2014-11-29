package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserList {

	private Map<Integer,User> userList;
	
	public UserList(){
		userList = new HashMap<Integer,User>();
	}

	public Map<Integer, User> getUserList() {
		return userList;
	}

	@Override
	public String toString() {
		Collection<User> c = userList.values();
		return c.toString();
	}

}
