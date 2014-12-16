package model.observer;

import model.UserList;
/**
 * 
 * @author Arthur & Hai An
 *
 */
public abstract class Observer {
	protected UserList ul;
	/**
	 * 
	 */
	public abstract void update();
}
