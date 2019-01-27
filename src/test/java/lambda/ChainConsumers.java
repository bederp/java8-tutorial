package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChainConsumers {

    public static void main(String... args) {
        
        List<String> strings = 
                Arrays.asList("one", "two", "three", "four", "five");
        
        List<String> result = new ArrayList<>();
        
        Consumer<String> c1 = System.out::println;
        
        strings.forEach(c1.andThen(result::add));
        System.out.println("size of result = " + result.size());
        
        strings.forEach(e->{System.out.println(e+", ");});
        
        System.out.println(strings.stream().collect(Collectors.joining(", ")));
    }
}
