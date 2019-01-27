package completable;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CombineTutor extends CompletableFutureBase {

	/**
	 * Define future3 as sum of future1 and future2 results (use thenCombine)
	 */
	@Test
	public void testThenCombine() throws Exception {
		   CompletableFuture<Integer> future1 = CompletableFuture
			.supplyAsync(this::slowInit)
			.thenApply(this::slowIncrement); // 2 
		   CompletableFuture<Integer> future2 = 
			CompletableFuture
			.supplyAsync(this::slowInit)
			.thenApply(this::slowIncrement); // 2
		   CompletableFuture<Integer> future3 = null;
		   
		   int result = future3.get();
		   assertEquals(result, 4);
		   System.out.println("result: "+future3.get()); // result: 4
		} // 2 sec passed

}
