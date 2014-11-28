package model;

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

}
