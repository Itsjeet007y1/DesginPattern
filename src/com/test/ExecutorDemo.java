package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Job implements Callable{

	String name;
	
	public Job(String name) {
		this.name = name;
	}
	
	@Override
	public Object call() {
		System.out.println(name + "... job started by thread " + Thread.currentThread().getName());
//		try {
//			Thread.sleep(5000);
//		} catch(InterruptedException e) {
//			System.out.println(e.getStackTrace());
//		}
		System.out.println("Job completed by thread " + Thread.currentThread().getName());
		return name;
	}	
}

public class ExecutorDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		@SuppressWarnings("rawtypes")
		List<Future> list = new ArrayList<>();
		Job[] jobs = { new Job("Jitendra"),
					   new Job("Suresh"),
					   new Job("Mahesh"),
					   new Job("Surendra"),
					   new Job("Manish"),
					   new Job("Rahul")
					 };
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(Job j: jobs) {
			Future<String> f = service.submit(j);
			list.add(f);
		}
		list.forEach(e -> {
			try {
				System.out.println(e.get());
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		service.shutdown();
	}
}
