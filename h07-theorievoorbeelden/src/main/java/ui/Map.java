package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import domein.Employee;

public class Map {
	
	public static void start() {
		mapInts();
		System.out.println();
		mapStrings();
		System.out.println();
		mapEmployees();
		System.out.println();
		mapToInt();
		System.out.println();
		mapToObj();
	}
	
	private static void mapInts() {
		System.out.printf("-- De getallen verdubbeld --%n");
		int[] values = { 13, 3, 26, 2, -99 };
		
		IntStream.of(values)
			.map(v -> v * 2)
			.forEach(v -> System.out.printf("%d ", v));
	}
	
	private static void mapStrings() {
		System.out.printf("%n-- De lengte van de strings --%n");
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		Arrays.stream(colors)
			.map(c -> c.length())
			.forEach(v -> System.out.printf("%d ", v));
	}
	
	private static void mapEmployees() {
		System.out.printf("%n-- De namen van de employees --%n");
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees,
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));
		
		employees.stream()
			.map(e -> e.getName())
			.forEach(n -> System.out.printf("%s   ", n));
	}
	
	private static void mapToInt() {
		System.out.printf("%n-- De lengte van de strings --%n");
		String[] colors = { "Red", "Brown", "Yellow", "Green", "Blue" };
		
		Arrays.stream(colors)
			.mapToInt(c -> c.length())
			.forEach(v -> System.out.printf("%d ", v));   //<1>
	}
	
	private static void mapToObj() {
		System.out.printf("%n-- De getallen als String --%n");
		int[] values = { 13, 3, 26, 2, -99 };
		
		IntStream.of(values)
			.mapToObj(v -> String.format("#%d", v))
			.forEach(v -> System.out.printf("%s ", v));
	}
}
