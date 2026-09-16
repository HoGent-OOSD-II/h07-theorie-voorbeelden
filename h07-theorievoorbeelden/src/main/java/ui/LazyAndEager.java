package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyAndEager {
	public static void start() {
		String[] colorArray = {"yellow", "green", "red", "orange"};
		List<String> colorList = new ArrayList<>(Arrays.asList(colorArray));
		// create stream + intermediate operation filter 
		// ! No terminal operation 
		Stream<String> stream = colorList.stream().filter(s -> s.length() > 5);
		
		// add 2 colors to list BEFORE terminal operation
		colorList.add("violet");
		colorList.add("blue");
		
		// terminal operation:
		long result = stream.count(); // result <- 3 (yellow, orange, violet)
		
		// add color to list AFTER terminal operation
		colorList.add("dark-grey");
		
		System.out.printf("Counted %d colors with a long name...%n", result);
		
		// second terminal operation:
		long result2 = stream.count(); // IllegalStateException!
	}
}
