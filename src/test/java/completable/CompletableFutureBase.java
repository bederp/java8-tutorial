package completable;

public class CompletableFutureBase {

  public Integer slowInit() {
    System.out.println("slowInit() Thread: " + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return 1;
  }

  public Integer slowIncrement(Integer i) {
    System.out.println("slowIncrement() Thread: " + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("finished increment with result " + (i + 1));
    return 1 + i;
  }
}
