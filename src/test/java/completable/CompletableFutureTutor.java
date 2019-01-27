package completable;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTutor extends CompletableFutureBase {
	
	
	/**
	 * Initialize CompletableFuture with slowInit, then perform slow increment 2 times
	 */
	public void promiseTestInc() throws Exception {
		long start = System.nanoTime();   


		long elapsedTime = System.nanoTime() - start;
		System.out.printf("%d sec passed", 
				TimeUnit.NANOSECONDS.toSeconds(elapsedTime));

		assertEquals(TimeUnit.NANOSECONDS.toSeconds(elapsedTime), 3);
	}

}
