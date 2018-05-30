package pluralsight.robert;

import pluralsight.robert.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

    public static void main(String... args) {
        List<Person> people = new ArrayList<>();

        Path path = Paths.get("c:\\Java\\WhatsNewInJava8\\Strings_IOandOtherBitsAndPieces\\src\\pluralsight\\robert", "people.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                        people.add(p);
                        return p;
                    })
//                    .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName))
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        List<Person> list1 = people.subList(1, 10);
        List<Person> list2 = people.subList(10, people.size());

        Map<Integer, List<Person>> map1 = mapByAge(list1);
        System.out.println("Map 1");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));

        Map<Integer, List<Person>> map2 = mapByAge(list2);
        System.out.println("Map 2");
        map2.forEach((age, list) -> System.out.println(age + " -> " + list));

        map2.entrySet().stream()
                .forEach(
                        entry -> map1.merge(
                                entry.getKey(),
                                entry.getValue(),
                                (l1, l2) -> {
                                    l1.addAll(l2);
                                    return l1;
                                }
                        )
                );

        System.out.println("Map 1 merged");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));
    }

    private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
        Map<Integer, List<Person>> map = list.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        return map;
    }
}
