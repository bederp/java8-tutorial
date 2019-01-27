package lambda.defaultmethods;

public interface Bar {
	
	default void someMethod(){
		System.out.println("Bar#someMethod");
	}
	
}
