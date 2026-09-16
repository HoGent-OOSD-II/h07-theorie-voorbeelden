package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Distinct {
	
	public static void start() {
		distinctInts();
		System.out.println();
		distinctStrings();
		System.out.println();
		distinctEmployees();
	}
	
	private static void distinctInts() {
		System.out.printf("-- Unieke getallen --%n");
		int[] values = { 13, 3, 13, 13, -13 };
		
		IntStream.of(values)
			.distinct()
			.forEach(v -> System.out.printf("%d ", v));
	}
	
	private static void distinctStrings() {
		System.out.printf("%n-- Unieke kleuren --%n");
		String[] colors = { "Yellow", "Brown", "yellow", "Yellow", "Brown" };
		
		Arrays.stream(colors)
			.distinct()
			.forEach(c -> System.out.printf("%s ", c));
	}
	
	private static void distinctEmployees() {
		System.out.printf("%n-- Unieke employees --%n");
		Employee jason = new Employee("Jason", "Red", 5000, "IT");
		Employee jason2 = jason;	// <1>
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees, 
				jason, 
				new Employee("Jason", "Red", 5000, "IT"),	// <2>
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				jason2);
		
		employees.stream()
			.distinct()
			.forEach(e -> System.out.printf("%s%n", e)); // <3>
	}

}
