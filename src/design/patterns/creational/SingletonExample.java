package design.patterns.creational;


class Singleton {
    // Private static instance of the Singleton class
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
        // Initialization code, if needed
    }

    // Public static method to access the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            // Lazy initialization: create the instance only when needed
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods of the Singleton class
    public void doSomething() {
        System.out.println("Singleton is doing something.");
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        // Call a method on the Singleton instance
        singleton1.doSomething();
    }
}
