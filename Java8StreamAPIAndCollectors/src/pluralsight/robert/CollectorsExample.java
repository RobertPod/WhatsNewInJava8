package pluralsight.robert;

import pluralsight.robert.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public static void main(String... args) {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));

                Stream<String> stream = reader.lines()
        ) {
            stream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Stream<Person> stream = persons.stream();
//        !!! We can use stream only ONCE.
//        !!! A Stream cannot be "reused"

        Optional<Person> opt =
                persons.stream().filter(p -> p.getAge() >= 20)
                        .min(Comparator.comparing(Person::getAge));
        System.out.println(opt);

        Optional<Person> opt2 =
                persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(opt2);

        Map<Integer, List<Person>> map =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge
                                )
                        );
        System.out.println(map);

        Map<Integer, Long> map2 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.counting()
                                )
                        );
        System.out.println(map2);

        Map<Integer, List<String>> map3 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println(map3);

        Map<Integer, Set<String>> map4 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toCollection(TreeSet::new)
                                        )
                                )
                        );
        System.out.println(map4);

        Map<Integer, String> map5 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.joining(", ")
                                        )
                                )
                        );
        System.out.println(map5);
    }
}
