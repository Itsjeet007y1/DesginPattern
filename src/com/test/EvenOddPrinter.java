package com.test;

public class EvenOddPrinter {
    private int limit;
    private volatile int currentNumber;

    public EvenOddPrinter(int limit) {
        this.limit = limit;
        this.currentNumber = 1;
    }

    public void printEven() {
        synchronized (this) {
            while (currentNumber <= limit) {
                if (currentNumber % 2 == 0) {
                    System.out.println("Even Thread: " + currentNumber);
                    currentNumber++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printOdd() {
        synchronized (this) {
            while (currentNumber <= limit) {
                if (currentNumber % 2 != 0) {
                    System.out.println("Odd Thread: " + currentNumber);
                    currentNumber++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int limit = 20;
        EvenOddPrinter printer = new EvenOddPrinter(limit);
        Employee1 emp = new Employee1(1, "AFD", 34);

        Thread evenThread = new Thread(() -> printer.printEven());
        Thread oddThread = new Thread(() -> printer.printOdd());

        evenThread.start();
        oddThread.start();
    }
}

