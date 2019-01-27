package datetime;

import java.util.TimeZone;

public class DateTimeTutor {

	public static void main(String[] args) {
		
		// 1) print current time in London in format "HH:mm dd/MM/yyyy"
		// use ZoneId.of("Europe/London") and then ZonedDateTime to retrieve London time
		// use format() method and DateTimeFormatter.ofPattern()
		
		// 2) calculate your age in days, months and years
		
		// 3) calculate and show the date of your next birthday in format dd.mm.yyyy
		
		// 4) calculate your age in seconds and in hours
		
		// 5) show day of the week of the next birthday

		// 6) check if your birthday this year is ahead or behind
		
		// 7) calculate time difference of local time and New York time
		// use TimeZone.getRawOffset() to calculate difference in time in milliseconds
		// use TimeZone.getTimeZone("America/New_York") to get New York time zone
		// use TimeZone().getDefault() to get local TimeZone
		// use TimeUnit.MILLISECONDS.toHours() to convert it to hours

		// 8) let we have New York time "02.04.2016 22:11"; calculate local time and print it in the same format
		// use ZonedDateTime.withZoneSameInstant() method and ZoneOffset.systemDefault() to get local ZoneId
		String time = "02.04.2016 22:11";
	}
}
