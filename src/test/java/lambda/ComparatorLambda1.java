package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda1 {

  public static void main(String... args) {
    Comparator<String> compLambda = Comparator.comparingInt(String::length);

    List<String> list = Arrays.asList("***", "**", "****", "*");
    list.sort(compLambda);

    list.forEach(System.out::println);
  }
}
