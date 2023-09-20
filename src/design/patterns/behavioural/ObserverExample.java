package design.patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/*
 * The Observer pattern defines a dependency between objects so that when one object 
 * changes state, all its dependents (observers) are notified and updated automatically.
 * 
 * Think about a weather app on your phone. It shows you the current temperature, humidity, 
 * and other details. Now, imagine you want to get notified whenever the temperature changes. 
 * You don't want to keep checking the app constantly. Instead, you'd like the app to tell you 
 * when something important happens, like when it's going to rain or when it's getting colder.

In a similar way, the Observer pattern in programming helps objects (like the weather app) 
communicate changes to other objects that are interested in those changes (like you). It's 
like having a list of people who want to know when something specific happens, and when that event occurs, 
the objects on the list automatically get notified.

So, the Observer pattern lets objects (the "observers") keep track of changes in other objects 
(the "subjects") without needing to constantly check them. This way, when something important happens, 
the observers get notified and can react accordingly. It's a way for objects to stay in the loop without 
always asking, "Did anything change?"
 */

// Observer interface
interface Observer {
	void update(double temprature);
}

// Subject interface
interface Subject {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver();
}

// Concrete Subject
class WeatherStation implements Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private double temprature;
	
	public void setTemprature(float temprature) {
		this.temprature = temprature;
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);	
	}

	@Override
	public void notifyObserver() {
		for(Observer observer: observers) {
			observer.update(temprature);
		}
	}
}

// Concrete Observer
class Display implements Observer {

	@Override
	public void update(double temprature) {
		System.out.println("Temprature updated: "+ temprature);
	}
}

public class ObserverExample {

	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		Observer display = new Display();
		
		station.registerObserver(display);
		station.removeObserver(display);
		display.update(23.0);
	}
}
