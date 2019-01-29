package stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomTutor {

  public static void main(String[] args) {
    Random rnd = new Random();

    IntStream intStream = rnd.ints().limit(10);

    String joined = intStream.boxed().map(Object::toString).collect(Collectors.joining(","));
    System.out.println(joined);

    IntStream intStream2 = rnd.ints().limit(10);
    System.out.println(intStream2.average().getAsDouble());

    List<Integer> intList = rnd.ints().limit(10).boxed().collect(Collectors.toList());
    System.out.println(intList.stream().mapToInt(Integer::intValue).sum());
  }
}
