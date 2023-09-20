package design.patterns.creational;


// Product class
class Computer {
	private String processor;
	private String memory;
	private String storage;
	private String graphicsCard;
	private boolean bluetoothEnabled;
	
	public Computer(String processor, String memory, String storage, String graphicsCard, boolean bluetoothEnabled) {
		this.processor = processor;
		this.memory = memory;
		this.storage = storage;
		this.graphicsCard = graphicsCard;
		this.bluetoothEnabled = bluetoothEnabled;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}

	public boolean isBluetoothEnabled() {
		return bluetoothEnabled;
	}

	public void setBluetoothEnabled(boolean bluetoothEnabled) {
		this.bluetoothEnabled = bluetoothEnabled;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Computer [processor=");
		builder.append(processor);
		builder.append(", memory=");
		builder.append(memory);
		builder.append(", storage=");
		builder.append(storage);
		builder.append(", graphicsCard=");
		builder.append(graphicsCard);
		builder.append(", bluetoothEnabled=");
		builder.append(bluetoothEnabled);
		builder.append("]");
		return builder.toString();
	}
	
	
}

// Builder interface
interface ComputerBuilder {
	ComputerBuilder setProcessor(String processor);
	ComputerBuilder setMemory(String memory);
	ComputerBuilder setStorage(String storage);
	ComputerBuilder setGraphicsCards(String graphicCards);
	ComputerBuilder bluetoothEnabled(boolean bluetoothEnabled);
	Computer build();
}

// Concrete Builder

class DesktopBuilder implements ComputerBuilder {
	
	private String processor;
	private String memory;
	private String storage;
	private String graphicsCard;
	private boolean bluetoothEnabled;

	@Override
	public ComputerBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	@Override
	public ComputerBuilder setMemory(String memory) {
		this.memory = memory;
		return this;
	}

	@Override
	public ComputerBuilder setStorage(String storage) {
		this.storage = storage;
		return this;
	}

	@Override
	public ComputerBuilder setGraphicsCards(String graphicCards) {
		this.graphicsCard = graphicCards;
		return this;
	}

	@Override
	public ComputerBuilder bluetoothEnabled(boolean bluetoothEnabled) {
		this.bluetoothEnabled = bluetoothEnabled;
		return this;
	}

	@Override
	public Computer build() {
		return new Computer(processor, memory, storage, graphicsCard, bluetoothEnabled);
	}
}

// Director class
class ComputerDirector {
	private ComputerBuilder builder;

	public ComputerDirector(ComputerBuilder builder) {
		this.builder = builder;
	}
	
	public Computer constructComputer() {
		return builder.setProcessor("Intel i9")
				.setMemory("32 gb")
				.setStorage("16tb")
				.setGraphicsCards("AMD")
				.bluetoothEnabled(true)
				.build();
	}
	
}

public class BuilderExample {
	public static void main(String[] args) {
		ComputerBuilder desktopBuilder = new DesktopBuilder();
		ComputerDirector director = new ComputerDirector(desktopBuilder);
		Computer desktopComputer = director.constructComputer();
		System.out.println("Desktop Computer Configuration: " + desktopComputer);
	}
}
