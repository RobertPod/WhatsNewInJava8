package pluralsight.robert;

import java.time.*;

public class TheDateAPIinJava8 {

    public static void main(String... args) {

        Instant start = Instant.now();
        System.out.println(Instant.MIN.toString());
        System.out.println(Instant.MAX.toString());
        System.out.println(Instant.now().toString());
        Instant stop = Instant.now();

        Duration elapsed = Duration.between(start, stop);
        long nanos = elapsed.toNanos();
        long millis = elapsed.toMillis();
        System.out.println(Long.toString(nanos));
        System.out.println(Long.toString(millis));

        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

        LocalDate myBirth = LocalDate.of(1959, Month.APRIL,21);
        System.out.println(myBirth.toString());

        Period p = myBirth.until(now);
        System.out.println(p.toString());


	// write your code here
    }
}
