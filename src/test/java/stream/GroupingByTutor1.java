package stream;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTutor1 {

	public static void main(String[] args) {
		
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales()); 
		// 1) Group locales by the country
		Map<String, List<Locale>> countryToLocales = locales.collect(
				Collectors.groupingBy(Locale::getCountry));
		
		countryToLocales.forEach((k,v)->System.out.println(k+" = "+v));

		locales = Stream.of(Locale.getAvailableLocales()); 
		// 2) Group locales by country and calculate how many locales are there for each country
		Map<String, Long> countryToLocaleCounts = locales.collect(
				Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
		countryToLocaleCounts.forEach((k,v)->System.out.println(k+" = "+v));
		
}
			
}
