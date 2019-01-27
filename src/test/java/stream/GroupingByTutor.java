package stream;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTutor {

	public static void main(String[] args) {
		
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		
		// 1) Group locales by the country
		// use stream.collect() method, and Collectors.groupingBy(Function) as a collector
		Map<String, List<Locale>> countryToLocales = null;
		
		countryToLocales.forEach((k,v)->System.out.println(k+" = "+v));

		// 2) Group locales by country and calculate how many locales are there for each country
		// use stream.collect() method, and Collectors.groupingBy(Function, Collector) as a collector
		// use Collectors.counting() as a collector for groupingBy()
		locales = Stream.of(Locale.getAvailableLocales()); 
		Map<String, Long> countryToLocaleCounts = null;
		countryToLocaleCounts.forEach((k,v)->System.out.println(k+" = "+v));
		
}
			
}
