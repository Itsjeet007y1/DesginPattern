package com.test;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		MyThread1 t1 = new MyThread1();
		Thread thread = new Thread(t);
		Thread thread1 = new Thread(t1);
		thread.start();
		thread1.start();
		
		System.out.println("Testing....");
		System.out.println("Git merge testing");
		System.out.println("Created practice1 branch.");
		System.out.println("Added first commit.");
		System.out.println("Added second commit.");
		for(int i = 0; i < 10; i ++) {
			System.out.println(LocalDateTime.now().getNano());
			System.out.println("Parent: "+ i);
		}
		
	}
	
}

class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(LocalDateTime.now().getNano());
			System.out.println("Child1:" + i);
		}
	}
	
}

class MyThread1 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(LocalDateTime.now().getNano());
			System.out.println("Child2:" + i);
		}
	}
	
}
