package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda1 {
    
    public static void main(String... args) {
        Comparator<String> compLambda = (String s1, String s2) ->
                Integer.compare(s1.length(), s2.length());
        
        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, compLambda);

        list.forEach(System.out::println);
    }
}
