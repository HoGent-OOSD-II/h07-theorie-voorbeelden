package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domein.Employee;

public class Collect {
	public static void start() {
		collectStrings();
		System.out.println();
		collectEmployees();
		System.out.println("\n");
		collectInts();
	}
	
	private static void collectStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue", "Blue" };
		
		System.out.printf("Our colors in 1 string: %s%n%n",
				Arrays.stream(colors)
					.sorted()
					.collect(Collectors.joining(" - "))	// <1>
			);
		
		Set<String> uniqueColors = Arrays.stream(colors)
				.collect(Collectors.toSet());	// <2>
		
		System.out.printf("Colors collected in a set, quite unique! %n");
		for (String c : uniqueColors) {
			System.out.printf("%s%n", c);
		}		
	}
	
	private static void collectEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		List<Employee> itEmployees = employees.stream()
				.filter(e -> e.getDepartment().equals("IT"))
				.collect(Collectors.toList());	// <1>
		
		System.out.printf("Modifiable list with IT employees: %n");
		for (Employee e : itEmployees) {
			System.out.printf("%s%n", e);
		}
		
		System.out.printf("%nAll employees in 1 string: %n%s", 
				employees.stream()
					.map(Employee::toString)
					.collect(Collectors.joining("\n"))	// <2>
				);
	}
	
	private static void collectInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		List<Double> squaredValuesOfEvenNumbers = IntStream.of(values)
				.filter(i -> i % 2 == 0)
				.mapToDouble(i -> Math.pow(i, 2))
				.boxed()
				.collect(Collectors.toList());
		
		System.out.printf("Resulting editable list with squares of even numbers%n");
		for (double d : squaredValuesOfEvenNumbers) {
			System.out.printf("%.2f   ", d);
		}
		
	}
}
