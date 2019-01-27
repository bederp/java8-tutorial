package func;

import java.util.function.Function;

public class LambdaTest {

  public static void main(String[] args) {
    LambdaTest lambdaTest = new LambdaTest();
    String s = lambdaTest.process("hello", lambdaTest::addExclam);
    System.out.println(s);
    System.out.println(lambdaTest.process("hello", x -> x + "?"));
  }

  public String process(String s, Function<String, String> f) {
    return f.apply(s);
  }

  public String addExclam(String s) {
    return s + "!";
  }
}
