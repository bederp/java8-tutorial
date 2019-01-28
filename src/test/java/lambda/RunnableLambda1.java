package lambda;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class RunnableLambda1 {

  public static void main(String... args) throws InterruptedException {
    Runnable runnableLambda = () -> IntStream.of(1, 2, 3).forEach(helloMessage());

    Thread t = new Thread(runnableLambda);
    t.start();
    t.join();
  }

  private static IntConsumer helloMessage() {
    return i -> System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
  }
}
