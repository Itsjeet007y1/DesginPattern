package com.test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamTest {
	
	public static void main(String[] args) {
		Employee1 emp1 = new Employee1(1, "2Ram", 20);
		Employee1 emp2 = new Employee1(2, "Rahul", 18);
		Employee1 emp3 = new Employee1(3, "Ravi", 52);
		Employee1 emp4 = new Employee1(4, "2Ramesh", 52);
		Employee1 emp5 = new Employee1(5, "Jitendra", 52);
		Employee1 emp6 = new Employee1(6, "Manish", 52);
		Employee1 emp7 = new Employee1(7, "Kushal", 52);
		
		List<Employee1> empList = new ArrayList<Employee1>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		empList.add(emp7);
		
		Map<Integer, String> map = new HashMap<>();
		map.put(101, "Ramesh");
		map.put(102, "Mahesh");
		map.put(103, "Kalu");
		map.put(104, "Matariya");
		
		Map<Integer, String> modMap = map.entrySet().stream().filter(e -> e.getValue().startsWith("M"))
						.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue));
		
		System.out.println(map);
		System.out.println(modMap);
		
		Map<Integer, String> mmap = map.entrySet().stream().map(entry -> new AbstractMap
										.SimpleEntry<>(entry.getKey(), entry.getValue().toUpperCase())).collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));
		
		System.out.println(mmap);
//		List<Employee1> soretedEmp = empList.stream()
//										.sorted(Comparator.comparing(Employee1 :: getEmpName).reversed())
//										.collect(Collectors.toList());
		
								
//		Map<Integer, List<Employee1>> map = soretedEmp.stream().collect(Collectors.groupingBy(Employee1 :: getEmpAge));

//		System.out.println(map);
//		map.forEach((age, employee) -> {
//			System.out.println("Age: " + age);
//			for(Employee1 emp : employee) {
//				System.out.println("Employee Id: " + emp.getEmpId());
//				System.out.println("Employee Name: " + emp.getEmpName());
//			}
//		});
//		
		List<Integer> empIdList = empList.stream().map(e -> e.getEmpId()).collect(Collectors.toList());
		
		System.out.println(empIdList);
//		
		long skippedSum = empIdList.stream().skip(3).mapToInt(Integer :: valueOf).sum();
		
		System.out.println(skippedSum);
		
		long thridLargest = empIdList.stream().sorted(Collections.reverseOrder()).distinct().skip(2).findFirst().get();
		System.out.println(thridLargest);
		
		int sum = empIdList.stream().mapToInt(Integer :: valueOf).sum();
		double average = empIdList.stream().mapToDouble(Double :: valueOf).average().getAsDouble();
//		System.out.println(average);
//		System.out.println(sum);
		
		
		
		long ager = empList.stream().map(e -> e.getEmpAge()).collect(Collectors.toList())
												.stream().map(e -> String.valueOf(e))
												.filter(e -> e.startsWith("5"))
												.map(Integer :: valueOf)
												.collect(Collectors.toList())
												.stream().count();
		empList.stream().count();
		empList.stream().sorted(Comparator.comparing(Employee1 :: getEmpName)).collect(Collectors.toList());
											
//		System.out.println(ager);
//		
//		empList.stream().anyMatch(e -> e.getEmpAge() == 1);
//		
//		System.out.println(empList.stream().anyMatch(e -> e.getEmpAge() == 52));
//		
//		empList.stream().peek(emp -> System.out.println("Employee" + emp));
		
		
		
//		System.out.println(soretedEmp);
	}
}

class Employee1 {
	
	
	public Employee1(int empId, String empName, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
	}
	
	private int empId;
	private String empName;
	private int empAge;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empId=");
		builder.append(empId);
		builder.append(", empName=");
		builder.append(empName);
		builder.append(", empAge=");
		builder.append(empAge);
		builder.append("]");
		return builder.toString();
	}
}