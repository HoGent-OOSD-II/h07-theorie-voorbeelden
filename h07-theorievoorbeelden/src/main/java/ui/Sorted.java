package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Sorted {
	
	public static void start() {
		sortInts();
		System.out.println();
		sortStrings();
		System.out.println();
		sortEmployees();
		System.out.println();
		sortEmployeesBySalaryDesc();
	}
	
	private static void sortInts() {
		System.out.printf("-- De gesorteerde getallen --%n");
		int[] values = { 13, 3, 26, 2, -99 };
		
		IntStream.of(values)
			.sorted()
			.forEach(v -> System.out.printf("%d ", v));
	}
	
	private static void sortStrings() {
		System.out.printf("%n-- De gesorteerde kleuren --%n");
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		Arrays.stream(colors)
			.sorted()
			.forEach(c -> System.out.printf("%s ", c));
	}
	
	private static void sortEmployees() {
		System.out.printf("%n-- De gesorteerde employees: sorteren op natuurlijke wijze --%n");
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		employees.stream()
			.sorted()
			.forEach(e -> System.out.printf("%s%n", e));
	}
	
	private static void sortEmployeesBySalaryDesc() {
		System.out.printf("%n-- De gesorteerde employees: dalend sorteren op salary --%n");
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		employees.stream()
			.sorted(Comparator.comparing(Employee::getSalary).reversed())
			.forEach(e -> System.out.printf("%s%n", e));
	}
}
