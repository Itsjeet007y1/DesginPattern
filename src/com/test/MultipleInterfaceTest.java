package com.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.function.Function;
import java.util.function.Predicate;

interface Left {
	default void m1() {
		System.out.println("Left inteface method.");
	}
}

interface Right {
	default void m1() {
		System.out.println("Right interface method.");
	}
} 

class Test1 implements Left, Right {
	public void m1() {
		System.out.println("Test class method.");
		Left.super.m1();
		Right.super.m1();
	}
}

public class MultipleInterfaceTest {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.m1();
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(100));
		Function<String, String> f = e -> e.toUpperCase();
		System.out.println(f.apply("rahul"));
		Year y = Year.of(2023);
		System.out.println(y.isLeap());
		LocalDate d = LocalDate.now();
		LocalDate birthday = LocalDate.of(1983, 2, 10);
		Period p1 = Period.between(birthday, d);
		System.out.println(p1.getYears() + " " + p1.getMonths() + " " + p1.getDays());
		for(int i = 1000; i < 2023; i++) {
			Year year = Year.of(i);
			if(year.isLeap())
				System.out.println("Year: " + i + " is leap year.");
		}
	}
}
