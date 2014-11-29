package pattern.observer;

import model.UserList;

public abstract class Observer {
	protected UserList ul;
	public abstract void update();
}
