package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PipelinePrinciple {
	public static void start() {
		filterLongColors();
		filterLongColorsWithChaining();
	}

	private static void filterLongColors() {
		List<String> dataSource = Arrays.asList("yellow", "green", "red", "orange"); 
		
		Stream<String> stream = dataSource.stream();	// <1>

		Stream<String> streamWithIntermediateOperation = 
				stream.filter(s -> s.length() > 5); 	// <2>

		long resultTerminalOperation = 
				streamWithIntermediateOperation.count();	// <3>
		
		System.out.printf("Counted %d colors with a long name%n", 
				resultTerminalOperation);
	}
	
	private static void filterLongColorsWithChaining() {
		List<String> namesOfColors = Arrays.asList("yellow", "green", "red", "orange");

		// create stream + intermediate operation + terminal operation 
		long result = namesOfColors.stream().filter(s -> s.length() > 5).count();

		System.out.printf("Counted %d colors with a long name%n", result);
	}
}
