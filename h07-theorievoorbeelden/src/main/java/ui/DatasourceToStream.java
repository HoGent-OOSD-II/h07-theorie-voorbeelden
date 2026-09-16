package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import domein.Employee;

public class DatasourceToStream {
	public static void start() {
		createStreamWithIntStream();
		createStreamFromArray();
		createStreamFromCollection();
	}

	private static void createStreamWithIntStream() {
		int[] values = { 3, 4, 6, 1 };
		IntStream stream1 = IntStream.of(values); // <1>
		IntStream stream2 = IntStream.of(-2, 3, 1, 6); // <2>
		IntStream stream3 = IntStream.range(4, 8); // <3>
		IntStream stream4 = IntStream.rangeClosed(4, 8); // <4>
	}
	
	private static void createStreamFromArray() {
		int[] values = { 3, 4, 6, 1 };
		IntStream intStream = Arrays.stream(values); // <1>
				
		String[] colors = { "Red", "Orange", "Yellow", "Green", "Blue" };
		Stream<String> colorStream = Arrays.stream(colors); // <2>
		Stream<String> someColors = Arrays.stream(colors, 1, 3); // <3>
		
		someColors.forEach(e->System.out.println(e));
	}
	
	private static void createStreamFromCollection() {
		List<Employee> employees = new ArrayList<>();
		Collections.addAll(employees, 
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"));

		Stream<Employee> employeeStream = employees.stream(); // <1>
	}

}
