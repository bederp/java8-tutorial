package completable;

import java.util.concurrent.CompletableFuture;
import static org.junit.Assert.*;

public class ComposeTutor1 extends CompletableFutureBase {
	
	/**
	 * 1) Define thenCompose as CompletableFuture
	 * 2) Use thenCompose() to put result of future1 into thenCompose
	 * 3) perform slowIncrement for thenCompose
	 * 
	 */
	public void promiseTestCompose2() throws Exception {
		CompletableFuture<Integer> future1 = 
				CompletableFuture.supplyAsync(this::slowInit) // 1 
					.thenApply(this::slowIncrement); // 2

		CompletableFuture<Integer> thenCompose = 
			future1.thenCompose(
				res -> CompletableFuture.supplyAsync(()->res)
				.thenApply(this::slowIncrement) ); // 3
		
		int result = thenCompose.get();
		System.out.println(result);
		assertEquals(result, 3);
	}

}
