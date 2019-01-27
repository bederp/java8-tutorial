package stream;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class IntStreamTutor1 {

  public static IntStream intStream() {
    return IntStream.of(2, 3, 3, 4);
  }

  public static void log(int i) {
    System.out.println(i);
  }

  public static void log(String i) {
    System.out.println(i);
  }


  /**
   * Find and print: - max number - average number - list of distinct values: "2,3,4"
   */
  @Test
  public void testIntStream() {

    int max = intStream().max().getAsInt();
    log(max);
    assertEquals(max, 4);

    int avg = (int) intStream().average().getAsDouble();
    log(avg);
    assertEquals(avg, 3);

    String distinct = intStream().distinct().
        boxed().map(s -> s.toString()).collect(Collectors.joining(","));
    log(distinct);
    assertEquals(distinct, "2,3,4");

  }
}

