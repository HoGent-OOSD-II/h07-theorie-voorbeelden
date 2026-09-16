package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import domein.Employee;

public class MinMaxAvg {
	public static void start() {
		minMaxAvgInts();
		System.out.println();
		minMaxStrings();
		System.out.println();
		minMaxEmployees();
	}

	private static void minMaxAvgInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		System.out.printf("Mininum equals %d%n", 
				IntStream.of(values)
				.min()
				.getAsInt()
			);
		System.out.printf("Maximum equals %d%n", 
				IntStream.of(values)
				.max()
				.getAsInt()
			);
		System.out.printf("Average equals %.2f%n", 
				IntStream.of(values)
				.average()
				.getAsDouble()
			);

	}
	
	private static void minMaxStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		System.out.printf("Longest color is: %s%n",
				Arrays.stream(colors)
				.max(Comparator.comparing(String::length))
				.get());
	}
	
	private static void minMaxEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		Optional<Employee> lowestPaidEmployee = // <1>
				employees.stream()
					.min(Comparator.comparing(Employee::getSalary));	
		System.out.printf("The lowest paid employee is %s%n", 
				lowestPaidEmployee.get()); // <2>
		System.out.printf("The name of the lowest paid employee is %s%n",
				lowestPaidEmployee.map(Employee::getName).orElse("!No employee found!"));	// <3>
		
		employees = new ArrayList<>();
		System.out.printf("The name of the lowest paid employee is %s%n", 
				employees.stream()
					.min(Comparator.comparing(Employee::getSalary))	// <4>
					.map(Employee::getName)	// <5>
					.orElse("!No employee found!"));	// <6>
	}
}
