package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class ToArray {
	public static void start() {
		toArrayInts();
		System.out.println("\n");
		toArrayStrings();
		System.out.println("\n");
		toArrayEmployees();
	}

	private static void toArrayInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		double[] squaredValuesOfEvenNumbers = IntStream.of(values)
				.filter(i -> i % 2 == 0)
				.mapToDouble(i -> Math.pow(i, 2))
				.toArray();
		
		System.out.printf("Resulting array with squares of even numbers%n");
		for (double d : squaredValuesOfEvenNumbers) {
			System.out.printf("%.2f   ", d);
		}
	}
	
	private static void toArrayStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		String[] sortedColors = Arrays.stream(colors)
				.sorted()
				.toArray(String[]::new);
		
		System.out.printf("Resulting array with sorted colors%n");
		for (String c : sortedColors) {
			System.out.printf("%s   ", c);
		}
	}
	
	private static void toArrayEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		Employee[] itEmployees = employees.stream()
				.filter(e -> e.getDepartment().equals("IT"))
				.toArray(Employee[]::new);
		
		System.out.printf("Array with employees of IT department: %n");
		for (Employee e : itEmployees) {
			System.out.printf("%s%n", e);
		}
	}
}
