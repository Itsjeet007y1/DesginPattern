package design.patterns.creational;

// Product interface
interface Vehicle {
	void manufacture();
}

// Concrete products
class Car implements Vehicle {

	@Override
	public void manufacture() {
		System.out.println("Car is being manufactured.");
	}
}

class Bike implements Vehicle {

	@Override
	public void manufacture() {
		System.out.println("Bike is being manufactured.");
	}
}

// Creator interface
interface VehicleFactory  {
	Vehicle createVehicle();
}

// Concrete creators
class CarFactory implements VehicleFactory {

	@Override
	public Vehicle createVehicle() {
		return new Car();
	}
}

class BikeFactory implements VehicleFactory {

	@Override
	public Vehicle createVehicle() {
		return new Bike();
	}
}

public class FactoryMethodExample {
	
	public static void main(String[] args) {
		VehicleFactory carFactory = new CarFactory();
		Vehicle car = carFactory.createVehicle();
		car.manufacture();
		
		VehicleFactory bikeFactory = new BikeFactory();
		Vehicle bike = bikeFactory.createVehicle();
		bike.manufacture();
	}
}
