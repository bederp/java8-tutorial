package stream;

import java.util.stream.Stream;

public class ReduceTutor {

	public static Stream<String> getStream() {
		return Stream.of("John Lennon", "Paul Mccartney", 
				"George Harrison", "Ringo Star");
	}
	
	/**
	 * Find the longest text in the stream in 2 ways and print it:
	 * - Using getStream().reduce()
	 */
	public static void main(String[] args) {

	}
	
}
