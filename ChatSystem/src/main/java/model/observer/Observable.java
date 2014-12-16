package model.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * from Pattern Observer
 * A class from the model need to extends the class Observable in order to become Observable
 * 
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
