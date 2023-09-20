package com.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Transaction {
	double amount;
	LocalDate transactionTime;
	public Transaction(double amount, LocalDate transactionTime) {
		this.amount = amount;
		this.transactionTime = transactionTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalDate transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	
	
	
	
}
public class EmployeeTest {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,45,45,23,424,424);
		int n = intList.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(n);
		BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
		System.out.println(biFunction.apply(10, 30));
		BiPredicate<Integer, Integer> biPredicate = (a, b) -> a.equals(b);
		System.out.println(biPredicate.test(10, 33));
		Consumer<Integer> c = item -> System.out.println(item);
		intList.forEach(c);
		Supplier<Integer> producer = () -> new Random().nextInt();
		System.out.println(producer.get());
		System.out.println(intList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
		System.out.println(intList.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).findFirst().get());
	}
}
