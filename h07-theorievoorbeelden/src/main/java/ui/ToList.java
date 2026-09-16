package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class ToList {

	public static void start() {
		toListStrings();
		System.out.println("\n");
		toListEmployees();
		System.out.println();
		toListInts();
		System.out.println();
		toListIntsWithAutoBoxing();
	}
	
	private static void toListStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		List<String> sortedColors = Arrays.stream(colors)
				.sorted()
				.toList();
		
		System.out.printf("Resulting list with sorted colors%n");
		for (String c : sortedColors) {
			System.out.printf("%s   ", c);
		}
	}
	
	private static void toListEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		List<Employee> itEmployees = employees.stream()
				.filter(e -> e.getDepartment().equals("IT"))
				.toList();
		
		System.out.printf("List with employees of IT department: %n");
		for (Employee e : itEmployees) {
			System.out.printf("%s%n", e);
		}
	}
	
	private static void toListInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		List<Double> squaredValuesOfEvenNumbers = IntStream.of(values)
				.filter(i -> i % 2 == 0)
				.mapToDouble(i -> Math.pow(i, 2))
				.boxed()
				.toList();
		
		System.out.printf("Resulting list with squares of even numbers%n");
		for (double d : squaredValuesOfEvenNumbers) { 	   //<1>
			System.out.printf("%.2f   ", d);
		}
	}

	private static void toListIntsWithAutoBoxing() {
		int[] values = { 13, 3, 26, 2, -99 };

		List<Double> squaredValuesOfEvenNumbers = IntStream.of(values)
				.filter(i -> i % 2 == 0)
				.mapToObj(i -> Math.pow(i, 2))
				.toList();

		System.out.printf("Resulting list with squares of even numbers%n");
		for (double d : squaredValuesOfEvenNumbers) {
			System.out.printf("%.2f   ", d);
		}
	}
}
