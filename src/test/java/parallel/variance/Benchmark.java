package parallel.variance;

import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public class Benchmark {

    private static final int POPULATION_SIZE = 30_000_000;
    double[] population;

    public void init() {
        population = DoubleStream.generate(Variance::randInt).limit(POPULATION_SIZE).toArray();
    }

    public double testVarianceImperative() {
        return Variance.varianceImperative(population);
    }

    public double testVarianceStreams() {
        return Variance.varianceStreams(population);
    }

    public double testVarianceForkJoin() {
        return Variance.varianceForkJoin(population);
    }
    
    public void benchmark(String name, Supplier<Double> f) {
		long start = System.currentTimeMillis();
		f.get();
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println(name+": time="+time+"ms");
	}

    public void executeBenchmark() {
    	init();
    	benchmark("testVarianceImperative", this::testVarianceImperative);    	
    	benchmark("testVarianceImperative", this::testVarianceImperative);    	
    	benchmark("testVarianceImperative", this::testVarianceImperative);    	
    	benchmark("testVarianceForkJoin", this::testVarianceForkJoin);    	
    	benchmark("testVarianceForkJoin", this::testVarianceForkJoin);    	
    	benchmark("testVarianceForkJoin", this::testVarianceForkJoin);    	
    	benchmark("testVarianceStreams", this::testVarianceStreams);    	
    	benchmark("testVarianceStreams", this::testVarianceStreams);    	
    	benchmark("testVarianceStreams", this::testVarianceStreams);    	
    }
    
    public static void main(String[] args) {
    	Benchmark b = new Benchmark();
    	b.executeBenchmark();
	}
}