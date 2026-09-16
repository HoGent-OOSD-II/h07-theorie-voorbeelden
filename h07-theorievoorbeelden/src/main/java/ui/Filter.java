package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Filter {
	public static void start() {
		filterInts();
		filterStrings();
		filterEmployees();
	}

	private static void filterInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		long nrOfValuesGreaterThan10 = IntStream.of(values)
				.filter(v -> v > 10)
				.count();
		System.out.printf("Number of values greater than 10: %d%n", nrOfValuesGreaterThan10);
		
		long nrOfEvenValues = IntStream.of(values)
				.filter(v -> v % 2 == 0)
				.count();
		System.out.printf("Number of even values: %d%n", nrOfEvenValues);
	}
	
	private static void filterStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		long nrOfColorsStartingWithB = Arrays.stream(colors)
				.filter(c -> c.startsWith("B"))
				.count();
		System.out.printf("Number of colors starting with 'B': %d%n", nrOfColorsStartingWithB);
	}
	
	private static void filterEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees, 
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		long nrOfEmployeesEarningAbove4500 = employees.stream()
				.filter(e -> e.getSalary() > 4500)
				.count();
		System.out.printf("Number of employees earning more than 4500: %d%n", nrOfEmployeesEarningAbove4500);
	}
}
