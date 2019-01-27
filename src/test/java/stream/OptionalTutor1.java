package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTutor1 {

    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList(1,2);
        
        Optional<Integer> opt = 
        list.stream()
                .reduce(Integer::max);
        Integer result = opt.orElse(0);
        
        Integer result2 = opt.orElseGet(() -> 2);
        Integer result3 = opt.orElseThrow(()->new RuntimeException("cannot get max"));
        
        System.out.println("max1 = " + result);
        System.out.println("max2 = " + result2);
        System.out.println("max3 = " + result3);
        
    }
}
