package parallel.sum;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Source taken from 
 * http://homes.cs.washington.edu/~djg/teachingMaterials/grossmanSPAC_forkJoinFramework.html
 *
 */
public class ForkJoinSum {
    static ForkJoinPool fjPool = new ForkJoinPool();

	static class Sum extends RecursiveTask<Long> {
	    static final int SEQUENTIAL_THRESHOLD = 5_000_00;
	
	    int low;
	    int high;
	    int[] array;
	
	    Sum(int[] arr, int lo, int hi) {
	        array = arr;
	        low   = lo;
	        high  = hi;
	    }
	
	    protected Long compute() {
	        if(high - low <= SEQUENTIAL_THRESHOLD) {
	            long sum = 0;
	            for(int i=low; i < high; ++i) 
	                sum += array[i];
	            return sum;
	         } else {
	            int mid = low + (high - low) / 2;
	            Sum left  = new Sum(array, low, mid);
	            Sum right = new Sum(array, mid, high);
	            left.fork();
	            long rightAns = right.compute();
	            long leftAns  = left.join();
	            return leftAns + rightAns;
	         }
	     }
	
	}

	interface SumCalculator {
		long sumArray(int[] array);
	}
	
	static long sumArrayForkJoin(int[] array) {
		return fjPool.invoke(new Sum(array,0,array.length));
	}

	static long sumArrayStream(int[] array) {
		return Arrays.stream(array).sum();
	}

	static long sumArrayStreamParallel(int[] array) {
		return Arrays.stream(array).parallel().sum();
	}

	static long sumArraySeq(int[] array) {
		long sum = 0;
		for (int i=0;i<array.length;i++) {
			sum += array[i];
		}
		return sum;
	}
	
	private static final Random rand = new Random();
    private static final int MIN = 1;
    private static final int MAX = 140;
    private static final int ARR_SIZE = 30_000_00;
    
    public static int randInt() {
        return rand.nextInt((MAX - MIN) + 1) + MIN;
    }

    public static void benchmark(String name, int[] array, SumCalculator f) {
		long start = System.currentTimeMillis();
		f.sumArray(array);
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println(name+": time="+time+"ms");
	}

	public static void main(String[] args) {
		int[] array = IntStream.generate(ForkJoinSum::randInt).limit(ARR_SIZE).toArray();
		benchmark("sumArrayForkJoin", array, ForkJoinSum::sumArrayForkJoin);
		benchmark("sumArrayForkJoin", array, ForkJoinSum::sumArrayForkJoin);
		benchmark("sumArrayForkJoin", array, ForkJoinSum::sumArrayForkJoin);
		benchmark("sumArrayStream", array, ForkJoinSum::sumArrayStream);
		benchmark("sumArrayStream", array, ForkJoinSum::sumArrayStream);
		benchmark("sumArrayStream", array, ForkJoinSum::sumArrayStream);
		benchmark("sumArrayStreamParallel", array, ForkJoinSum::sumArrayStreamParallel);
		benchmark("sumArrayStreamParallel", array, ForkJoinSum::sumArrayStreamParallel);
		benchmark("sumArrayStreamParallel", array, ForkJoinSum::sumArrayStreamParallel);
		benchmark("sumArraySeq", array, ForkJoinSum::sumArraySeq);
		benchmark("sumArraySeq", array, ForkJoinSum::sumArraySeq);
	}
}
