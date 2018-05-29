package pluralsight.robert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class NewMethodsOnCollection {

    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("jeden", "two", "trzy", "four", "1", "22", "333", "4444", "55555");

        Collection<String> list = new ArrayList<>(strings);

        boolean b = list.removeIf(s -> s.length() > 4);
        ((ArrayList<String>) list).replaceAll(String::toUpperCase);
        ((ArrayList<String>) list).sort(Comparator.naturalOrder());

        System.out.println(list.stream().collect(Collectors.joining(", ")));
    }
}
