package design.patterns.behavioural;

/*
 * Imagine you're getting ready for a trip, and you have a choice of different ways to travel: 
 * car, train, or airplane. Each option has its own advantages and disadvantages. Now, let's say 
 * you want to be able to switch between these travel options easily, depending on your needs for each 
 * trip. That's where the Strategy pattern comes in.
	
	In a similar way, the Strategy pattern in programming helps you handle different ways of doing 
	something, like traveling, by creating a set of strategies (or plans) that you can choose from. 
	Each strategy represents a different approach to solving a problem. So, instead of writing all the different approaches directly into your code, you create separate strategies and select the one you want to use. This makes your code more flexible because you can change your approach without changing the main part of your code.
	
	In essence, the Strategy pattern is like having a menu of different methods or plans, and you 
	can pick the one that works best for your situation.
 * 
 */


// strategy interface
interface PaymentStrategy {
	void pay(long amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
	
	private String cardNumber;
	
	public CreditCardPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(long amount) {
		System.out.println("Paid amount: $ " + amount + " using credit card number: " + cardNumber);
	}
}

class PaypalPayment implements PaymentStrategy {
	
	private String paypalId;
	
	public PaypalPayment(String paypalId) {
		this.paypalId = paypalId;
	}
	
	@Override
	public void pay(long amount) {
		System.out.println("Paid amount: $ " + amount + " using paypal ID: " + paypalId);
	}
}

// Context
class ShoppingCart {
	private PaymentStrategy paymentStrategy;
	
	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void checkout(int amount) {
		paymentStrategy.pay(amount);
	}
}

public class StrategyExample {
	public static void main(String[] args) {
		PaymentStrategy creditPaymentStrategy = new CreditCardPayment("1234 5647 2145 6589");
		PaymentStrategy paypalPaymentStrategy = new PaypalPayment("Jitendra7@paypal.com");
		
		ShoppingCart cart = new ShoppingCart();
		cart.setPaymentStrategy(paypalPaymentStrategy);
		cart.checkout(100);
		
		cart.setPaymentStrategy(creditPaymentStrategy);
		cart.checkout(254);
	}
}
