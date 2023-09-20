package design.patterns.structural;


// Adaptee class (a class with an incompatible interface)
class FahrenheitSensor {
	public double getTemprature() {
		// Process and give the temperature in fahrenheit
		return 72.5;
	}
}

// Target interface expected by the client
interface CelsiusCensor {
	double getTemperatureInCelsiuc();
}

// Adapter class that adapts fahrenheitSensor to celsiusSensor
class FahrenheitToCelsiusAdapter implements CelsiusCensor {

	private FahrenheitSensor fahrenheitSensor;
	
	
	public FahrenheitToCelsiusAdapter(FahrenheitSensor fahrenheitSensor) {
		this.fahrenheitSensor = fahrenheitSensor;
	}


	// Convert Fahrenheit to Celsius
	@Override
	public double getTemperatureInCelsiuc() {
		double fahrenheitTemprature = fahrenheitSensor.getTemprature();
		//convert f to c
		return (fahrenheitTemprature - 32.0) * 5.0/9.0;
	}
	
}

public class AdapterExample {
	public static void main(String[] args) {
		FahrenheitSensor fs = new FahrenheitSensor();
		CelsiusCensor cs = new FahrenheitToCelsiusAdapter(fs);
		System.out.println("Temprature in celsius: "+ cs.getTemperatureInCelsiuc());
	}
}
