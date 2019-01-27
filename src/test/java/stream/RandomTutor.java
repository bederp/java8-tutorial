package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomTutor {

	public static void main(String[] args) {
		Random rnd = new Random();
		
		List<Integer> intList = rnd.ints().limit(10).boxed().collect(Collectors.toList());
		
		int[] ints = rnd.ints().limit(10).toArray();
		
		IntStream intStream = Arrays.stream(ints);
		String joined = intStream.boxed().map((i)->i.toString())
			.collect(Collectors.joining(","));
		System.out.println(joined);
		intStream = Arrays.stream(ints);
		System.out.println(intStream.average().getAsDouble());
		
		System.out.println(intList.stream().mapToInt(Integer::intValue)
				.sum());
				
	}
}
