package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void notifyAllObservers(){
		for(Observer observer : observers){
			observer.update();
		}
	}
	
	
}
