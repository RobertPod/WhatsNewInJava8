package pluralsight.robert;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ZonedTimeExample {

    public static void main(String... args) {

        Set<String> allZonesIds = ZoneId.getAvailableZoneIds();
        allZonesIds.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println(allZonesIds);

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        ZonedDateTime nowCA1 = now.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println(nowCA1);
        ZonedDateTime nowCA2 = now.withZoneSameLocal(ZoneId.of("America/Los_Angeles"));
        System.out.println(nowCA2);
        ZonedDateTime nowCA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(nowCA);


        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(now));
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(now));
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now));


    }
}
