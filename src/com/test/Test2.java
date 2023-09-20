package com.test;

import java.util.HashMap;
import java.util.Map;

class Employee {
	private String name;
	
	public Employee(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}	
	
}

public class Test2 {

	public static void main(String[] args) {
		
		
		Employee e1 = new Employee("Jitendra");
		Employee e2 = new Employee("Jitendra");
		
		String s1 = new String("Jitendra");
		String s2 = new String("Jitendra");
		
		Map<Employee, String> map = new HashMap<Employee, String>();
		Map<String, String> map1 = new HashMap<String, String>();
		
		map.put(e1, "Naveen");
		map.put(e2, "Irfan");
		
		map1.put(s1, "Hello");
		map1.put(s2, "Hsdfsdf");
		
		System.out.println(map1);
		
		
		System.out.println(map);
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		System.out.println(e1 == e2);
		
		System.out.println(e1.equals(e2));
	}
}
