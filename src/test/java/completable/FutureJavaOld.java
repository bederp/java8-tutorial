package completable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class FutureJavaOld extends CompletableFutureBase {

	int result;
	@Test
	public void testFutureOldStyle() throws InterruptedException {		
		Thread t = new Thread() {
			public void run() {
				result = slowInit();				
			};
		};
		
		t.start();
		t.join();
		System.out.println("futureTest() is finished: "+result);
	}
	
	public void futureTest() 
		throws InterruptedException, ExecutionException {
	
		Callable<Integer> r = this::slowInit;
		ExecutorService es =
				Executors.newFixedThreadPool(10);
		Future<Integer> future = es.submit(r);

		Integer res = future.get();

		System.out.println("futureTest() is finished: "+res);
	}
	
	public void promiseTestNext() 
		throws InterruptedException, ExecutionException {
			CompletableFuture<Void> future = 
				CompletableFuture
				.supplyAsync(this::slowInit)
				.thenAccept(
					  (res) -> { System.out.println("finished "+res); }
					)
				.thenRun(
					() -> { System.out.println("look at results"); }
				);
			future.get();
			System.out.println("promiseTestNext() is finished");
	}

}
