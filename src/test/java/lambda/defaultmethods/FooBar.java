package lambda.defaultmethods;

public class FooBar implements Foo, Bar {

  public static void main(String[] args) {
    System.out.println("FooBar#main");

    FooBar fooBar = new FooBar();
    fooBar.someMethod();
    fooBar.someOtherMethod();
  }

  @Override
  public void someMethod() {
    System.out.println("FooBar#someMethod");
  }
}
