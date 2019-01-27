package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompletableFutureTutor1 extends CompletableFutureBase {
	
	
	/**
	 * Initialize CompletableFuture with slowInit, then perform slow increment 2 times
	 */
	@Test
	public void promiseTestInc() throws Exception {
		long start = System.nanoTime();   

		CompletableFuture<?> future = 
				CompletableFuture.supplyAsync(this::slowInit) // 1 
					.thenApply(this::slowIncrement) // 2 
					.thenApply(this::slowIncrement) // 3 
					.thenAccept( res -> 
						System.out.println("async result: "+res) );
		future.get();

		long elapsedTime = System.nanoTime() - start;
		System.out.printf("%d sec passed", 
				TimeUnit.NANOSECONDS.toSeconds(elapsedTime));

		assertEquals(TimeUnit.NANOSECONDS.toSeconds(elapsedTime), 3);
	}

}
