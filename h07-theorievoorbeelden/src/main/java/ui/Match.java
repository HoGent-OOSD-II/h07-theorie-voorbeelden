package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Match {
	public static void start() {
		matchInts();
		System.out.println();
		matchStrings();
		System.out.println();
		matchEmployees();
	}

	private static void matchInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		System.out.printf("There is %s element greater than 25%n",
				IntStream.of(values).anyMatch(e -> e > 25) ? "an" : "no");
		
		System.out.printf("%s elements are greater than 25%n",
				IntStream.of(values).allMatch(e -> e > 25) ? "All" : "Not all");
		
	}
	
	private static void matchStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		System.out.printf("The colors %scontain Yellow%n",
				Arrays.stream(colors).anyMatch(c -> c.equals("Yellow")) ? "" : "don't ");
	}
	
	private static void matchEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		System.out.printf("There is %s employee by the name of Green%n",
				employees.stream().anyMatch(e -> e.getLastName().equals("Green")) ? "an" : "no");
		
		System.out.printf("There is %s employee by the name of Java%n",
				employees.stream().anyMatch(e -> e.getLastName().equals("Java")) ? "an" : "no");
	}
}
