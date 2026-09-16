package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Sum {
	public static void start() {
		sumInts();
		System.out.println();
		sumStrings();
		System.out.println();
		sumEmployees();
	}

	private static void sumInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		long sum = IntStream.of(values)
				.sum();
		System.out.printf("Sum equals %d%n", sum);
		
		long sumOfSquares = IntStream.of(values)
				.map(v -> (int) Math.pow(v, 2))
				.sum();
		System.out.printf("Sum of squares equals %d%n", sumOfSquares);
	}
	
	private static void sumStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		long numberOfLetters = Arrays.stream(colors)
				.mapToInt(c -> c.length())
				.sum();
		System.out.printf("Number of letters in our colors: %d%n", numberOfLetters);
	}
	
	private static void sumEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		double totalSalary = employees.stream()
				.mapToDouble(e -> e.getSalary())
				.sum();
		System.out.printf("Total salaries equals %.2f%n", totalSalary);
	}
}
