package pluralsight.robert;

import java.time.*;

public class LocalTimeExample {

    public static void main(String... args) {

        LocalTime now = LocalTime.now();
        System.out.println(now.toString());

        LocalTime wakeUpTime = LocalTime.of(5, 30);
        LocalTime bedTime = wakeUpTime.minusHours(8);
        System.out.println(bedTime);

    }
}
