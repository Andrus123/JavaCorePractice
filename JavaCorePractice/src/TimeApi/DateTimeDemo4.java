package TimeApi;

// Parse a date and time
import java.time.*;
import java.time.format.*;

public class DateTimeDemo4 {
	public static void main(String[] args) {
		// Obtain a LocalDateTime object by parsing a date and time string.
		LocalDateTime curDateTime = LocalDateTime.parse("June 30, 2021 12:01 AM",
				DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a"));
		// Now, display the parsed date and time.
		System.out.println(curDateTime.format(DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a")));
	}
}
