package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Try to get default value using 
 * - opt.orElse(0);
 * - opt.orElseThrow
 * - opt.orElseGet
 * Add some elements to the array.
 *
 */
public class OptionalTutor {

    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList();
        
        Optional<Integer> opt = 
	        list.stream()
	                .reduce(Integer::max);
        System.out.println("max = " + opt);
        
    }
}
