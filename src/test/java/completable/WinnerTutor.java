package completable;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class WinnerTutor extends CompletableFutureBase {

	/**
	 * Take the fastest of future1 and future2 and increment the result
	 * @throws Exception
	 */
	@Test
	public void testApplyToEither() throws Exception {
		  long start = System.nanoTime();   

		  CompletableFuture<Integer> future1 = 
			CompletableFuture.supplyAsync(this::slowInit)
			.thenApply(this::slowIncrement)
			.thenApply(this::slowIncrement);
		  CompletableFuture<Integer> future2 = 
			CompletableFuture.supplyAsync(this::slowInit)
			.thenApply(this::slowIncrement);
		  CompletableFuture<Integer> winner = null;
		  
		  int result = winner.get();
		  System.out.println("result: "+result); // result: 3

		  long elapsedTime = System.nanoTime() - start;
		  System.out.printf("%d sec passed", 
				TimeUnit.NANOSECONDS.toSeconds(elapsedTime));
		
		  assertEquals(result, 3);
		  assertEquals(TimeUnit.NANOSECONDS.toSeconds(elapsedTime), 3);
		  
		} 

}
