package pluralsight.robert;

import java.util.Calendar;
import java.util.Date;

public class TheDateAPIinJava7 {

    public static void main(String... args) {

        Date date = new Date();
        System.out.println(date.toString()); // just now!

        Calendar calendar = Calendar.getInstance(); // just now!
        System.out.println(calendar.toString());
        System.out.println(calendar.getTime().toString());


	// write your code here
    }
}
