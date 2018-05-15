package pluralsight.robert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAnonymousClass {

    public static void main(String[] args) {

        Comparator comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        List<String> list = Arrays.asList("***", "**", "****", "*", "***");
        Collections.sort(list, comparator);

        for (String s : list) {
            System.out.println(s);
        }
    }
}

