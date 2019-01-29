package stream;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class IntStreamTutor {

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
   * Find and print: - max number in intStream - average number in intStream - list of distinct values: "2,3,4" (use
   * distinct())
   */
  @Test
  public void testIntStream() {

    Integer max = null;
    log(max);
//    assertEquals(max, 4);

    Integer avg = null;
    log(avg);
//    assertEquals(avg, 3);

    String distinct = null;
    log(distinct);
//    assertEquals(distinct, "2,3,4");
  }
}
