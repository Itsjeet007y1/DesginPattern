package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test3 {
	public static void main(String[] args) {
		String s1 = new String("Akbar");
		String s2 = new String("Akbar");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode()); 
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		Map<Integer, String> m2	= new HashMap<Integer, String>();
		m2.put(i2, "K");
		m2.put(i1, "K");
		
		System.out.println(m2);
		
		Map<String, String> m = new HashMap<String,String>();
		m.put(s1, "Hello");
		m.put(s2, "Hello");
		
		Employees e1 = new Employees("Jitendra");
		Employees e2 = new Employees("Jitendra");
		
		
		Map<Employees, String> map = new HashMap<Employees,String>();
		map.put(e1, "Hi");
		map.put(e2, "Hi");
		
		System.out.println(m);
		System.out.println(map);
		
		List<String> a = new CopyOnWriteArrayList<String>();	
		a.add("sdf");
		a.add("sdfdsf");
		
		a.forEach(e -> {
			System.out.println(e);
			a.add("sdfdd");
		});
	}
}

class Employees {
	String name;
	
	Employees(String name) {
		this.name = name;
	}
	
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employees [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
