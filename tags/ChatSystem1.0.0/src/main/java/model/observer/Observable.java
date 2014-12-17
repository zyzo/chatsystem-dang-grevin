package model.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * A class extending <code>Observable</code> becomes observable 
 * by any registered <code>Observer</code>
 * @author Arthur & Hai An
 *
 */
public class Observable {
	private List<Observer> observers = new ArrayList<Observer>();

	/**
	 * Add a new observer
	 * @param observer
	 * 
	 */
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * Update all the Observer from the list observers <br>
	 * Use to notify the observer when a change happen to the observer
	 */
	public void notifyAllObservers(){
		for(Observer observer : observers){
			observer.update();
		}
	}
	
	
}
