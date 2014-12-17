package model.observer;

import model.UserList;
/**
 * <code>Observer</code> class in the Observer Pattern
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
