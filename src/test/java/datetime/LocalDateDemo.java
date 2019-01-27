package datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class LocalDateDemo {

	public static void main(String[] args) {
		LocalDateTime timePoint = LocalDateTime.now();     // The current date and time
		LocalDate.of(2012, Month.DECEMBER, 12); // from values
		LocalDate.ofEpochDay(150);  // middle of 1970
		LocalTime.of(17, 18); // the train I took home today
		LocalTime.parse("10:15:30"); // From a String
		
		LocalDate theDate = timePoint.toLocalDate();
		Month month = timePoint.getMonth();
		int day = timePoint.getDayOfMonth();
		timePoint.getSecond();
		
		// Set the value, returning a new object
		LocalDateTime thePast = timePoint.withDayOfMonth(
		    10).withYear(2010);

		/* You can use direct manipulation methods, 
		    or pass a value and field pair */
		LocalDateTime yetAnother = thePast.plusWeeks(
		    3).plus(3, ChronoUnit.WEEKS);
		
		
		LocalDate today = LocalDate.now();
		LocalDate payday = today.with(
				TemporalAdjusters.lastDayOfMonth()).minusDays(2);

		LocalDate dateOfBirth = LocalDate.of(2012, Month.MAY, 14);
		LocalDate firstBirthday = dateOfBirth.plusYears(1);
		
		// Returns the current time based on your system clock and set to UTC. 
		Clock clock = Clock.systemUTC(); 
		System.out.println("Clock : " + LocalDateTime.now(clock)); 
		// Returns time based on system clock zone 
		Clock defaultClock = Clock.systemDefaultZone(); 
		System.out.println("Clock : " + LocalDateTime.now(defaultClock )); 
	
	}
	
}
