package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Reduce {
	public static void start() {
		reduceInts();
		System.out.println();
		reduceStrings();
		System.out.println();
		reduceEmployees();
	}

	private static void reduceInts() {
		int[] values = { 13, 3, 26, 2, -99 };

		System.out.printf("Sum of all values via reduce method: %d%n",
				IntStream.of(values)
					.reduce((i1, i2) -> i1 + i2)		// <1>
					.getAsInt()
			);

		System.out.printf("Sum of all even values via reduce method: %d%n",
				IntStream.of(values)
					.filter(i -> i % 2 == 0)		// <2>
					.reduce((i1, i2) -> i1 + i2)
					.getAsInt()
			);
		
	}
	
	private static void reduceStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		System.out.printf("First letters of our colors: %s%n",
				Arrays.stream(colors)
					.reduce("", (c1, c2) -> c1 + c2.substring(0, 1))
			);
	}
	
	private static void reduceEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		System.out.printf("Initials of all our employees: %s",
				employees.stream()
					.map(e -> e.getFirstName().substring(0, 1) + e.getLastName().substring(0, 1))
					.reduce("", (s1, s2) -> s1 + s2 + " ")
				);
	}
}
