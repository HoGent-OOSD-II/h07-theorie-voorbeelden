package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import domein.Employee;

public class Find {
	public static void start() {
		findInts();
		System.out.println();
		findStrings();
		System.out.println();
		findEmployees();
	}

	private static void findInts() {
		int[] values = { 13, 3, 26, 2, -99 };
		
		// <1>
		OptionalInt resultFirst = IntStream.of(values)
				.filter(v -> v > 10)
				.findFirst();
		System.out.printf("First value > 10 is: %d%n", resultFirst.getAsInt());
		
		// <2>
		OptionalInt resultAny = IntStream.of(values)
				.filter(v -> v > 10)
				.findAny();
		System.out.printf("A value > 10 is: %d%n", resultAny.getAsInt());
		
		// <3>
		OptionalInt resultNotFound = IntStream.of(values)
				.filter(v -> v > 50)
				.findAny();
		System.out.printf("%s value > 50! %n", 
				resultNotFound.isPresent()? "A": "No");
	}
	
	private static void findStrings() {
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		String resultFindB = Arrays.stream(colors)
				.filter(c -> c.startsWith("B"))
				.findFirst()
				.orElse("No color found");
		System.out.printf("Color starting with 'B': %s%n", resultFindB);
		
		String resultFindC = Arrays.stream(colors)
				.filter(c -> c.startsWith("C"))
				.findFirst()
				.orElse("No color found");
		System.out.printf("Color starting with 'C': %s%n", resultFindC);
	}
	
	private static void findEmployees() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		Optional<Employee> employeesEarningAbove4500 = employees.stream()
				.filter(e -> e.getSalary() > 4500)
				.findAny();
		System.out.printf("An employee earning more than 4500: %n%s%n", 
				employeesEarningAbove4500.get());
	}
}
