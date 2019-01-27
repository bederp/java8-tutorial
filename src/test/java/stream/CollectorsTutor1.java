package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import stream.model.Gender;
import stream.model.Person;

public class CollectorsTutor1 {

    public static void main(String... args)  {
        
        List<Person> persons = new ArrayList<>();
        
        try (
            BufferedReader reader = 
                new BufferedReader(
                    new InputStreamReader(
                        CollectorsTutor1.class.getResourceAsStream("people.txt")));

            Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                persons.add(p);
                return p;
                    })
                    .forEach(System.out::println);
                
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        
        Optional<Person> opt = 
        persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println(opt);
        
        Optional<Person> opt2 = 
        		persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(opt2);
        
        Map<Integer, String> map = 
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge, 
                                Collectors.mapping(
                                        Person::getName, 
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println(map);
        
        // 1) Create a map which prints amount of person of each age
        Map<Integer, Long> map2 = 
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge, 
                                Collectors.mapping(
                                        Person::getName, 
                                        Collectors.counting()
                                )
                        )
                );
        System.out.println(map2);
        
        // 2) Create a map by gender
        Map<Gender, String> map3 = 
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender, 
                                Collectors.mapping(
                                        Person::getName, 
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println(map3);
        
        // 3) Calculate and print the average age of female
        OptionalDouble average = persons.stream()
        	.filter(p->p.getGender()==Gender.Female)
        	.mapToInt(Person::getAge)
        	.average();
        
        System.out.println("Average female age = " + average.getAsDouble());
        
        // 4) Create a map with genders as keys and average ages as values
        Map<Gender, Double> map4 = 
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender, 
                                Collectors.averagingInt(Person::getAge)
                        )
                );
        System.out.println("Map of average ages: " + map4);
        
        // 5) Print the list of persons in alphabetical order
        persons.stream()
        	.sorted(Comparator.comparing(p->p.getName()))
        	.forEach(System.out::println);

        // 6) Print the list of persons in order of gender, then name
        System.out.println("Print the list of persons in order of gender, then name");
        persons.stream()
        	.sorted(
        			Comparator
        			.comparing((Person p)->p.getGender())
        				.thenComparing((p)->p.getName()))
        	.forEach(System.out::println);
        
    }
}
