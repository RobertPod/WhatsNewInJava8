package pluralsight.robert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        stream
                .peek(System.out::println)
                .filter(p2.or(p3))
                .peek(strings::add)
                .peek(System.out::println)
                .filter(p1)
                .forEach(System.out::println);

        System.out.println("strings size: " + strings.size());
    }
}
