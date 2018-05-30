package pluralsight.robert;

import pluralsight.robert.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingBMap {
    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();

        Path path = Paths.get("c:\\Java\\WhatsNewInJava8\\Strings_IOandOtherBitsAndPieces\\src\\pluralsight\\robert", "people.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                        persons.add(p);
                        return p;
                    })
//                    .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName))
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        persons.forEach(System.out::println);

        Map<Integer, List<Person>> map = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
        map.forEach((age, list) -> System.out.println(age + " -> " + list));

        Map<Integer, Map<String, List<Person>>> bimap = new HashMap<>();

        persons.forEach(
                person ->
                        bimap.computeIfAbsent(
                                person.getAge(),
                                HashMap::new
                        ).merge(
                                person.getGender(),
                                new ArrayList<>(Arrays.asList(person)),
                                (l1, l2) -> {
                                    l1.addAll(l2);
                                    return l1;
                                }
                        )
        );

        System.out.println("Bimap : ");
        bimap.forEach(
                (age, m) -> System.out.println(age + " -> " + m)
        );

    }
}
