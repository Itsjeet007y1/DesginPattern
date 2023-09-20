package design.patterns.structural;

// Component
interface Coffee {
	double cost();
}

// Concrete Components
class Espresso implements Coffee {
	@Override
	public double cost() {
		return 2.0;
	}
}

class Decaf implements Coffee {
	@Override
	public double cost() {
		return 1.5;
	}
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
	
	protected Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double cost() {
		return coffee.cost();
	}
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
	
	public MilkDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return coffee.cost() + 0.5;
	}
	
}

class SugarDecorator extends CoffeeDecorator {

	public SugarDecorator(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public double cost() {
		return coffee.cost() + 0.2;
	}
}

public class DecoratorExample {

	public static void main(String[] args) {
		Coffee coffee = new Espresso();
		System.out.println("Cost of Espresso: "+ coffee.cost());
		
		Coffee coffeeWithMilkAndSugar = new SugarDecorator(new MilkDecorator(coffee));
		System.out.println("Coffee with sugar and milk costs: "+ coffeeWithMilkAndSugar.cost());
	}
}
