package stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceTutor1 {

	public static Stream<String> getStream() {
		return Stream.of("John Lennon", "Paul Mccartney", 
				"George Harrison", "Ringo Star");
	}
	
	/**
	 * Find the longest text in the stream in 2 ways and print it:
	 * - Using getStream().collect()
	 * - Using getStream().reduce()
	 */
	public static void main(String[] args) {
		
		Optional<String> reduced = getStream()
				.reduce((s1,s2)->s1.length()>s2.length()?s1:s2);
		System.out.println(reduced.get());

		
		// other solutions using collect()
		Optional<String> max1 = 
			getStream().collect(
					Collectors.maxBy((s1, s2)->s1.length()-s2.length()));
		System.out.println(max1.get());

		Optional<String> max = 
			getStream().collect(
				Collectors.maxBy(Comparator.comparing(String::length)));
		System.out.println(max.get());
		
	}
	
}
