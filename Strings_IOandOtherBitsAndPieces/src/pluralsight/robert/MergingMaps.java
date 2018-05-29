package pluralsight.robert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

    public static void main(String... args) {
        List<Pearson> pearsons = new ArrayList<>();

        Path path = Paths.get("c:\\Java\\WhatsNewInJava8\\Strings_IOandOtherBitsAndPieces\\src\\pluralsight\\robert", "people.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream
                    .map(line -> {
                        String[] s = line.split(" ");
                        Pearson p = new Pearson(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
                        pearsons.add(p);
                        return p;
                    })
                    .sorted(Comparator.comparing(Pearson::getAge).reversed().thenComparing(Pearson::getName))
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        List<Pearson> list1 = pearsons.subList(1, 10);
        List<Pearson> list2 = pearsons.subList(10, pearsons.size());

        Map<Integer, List<Pearson>> map1 = mapByAge(list1);
        System.out.println("Map 1");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));

        Map<Integer, List<Pearson>> map2 = mapByAge(list2);
        System.out.println("Map 2");
        map2.forEach((age, list) -> System.out.println(age + " -> " + list));
    }

    private static Map<Integer, List<Pearson>> mapByAge(List<Pearson> list) {
        Map<Integer, List<Pearson>> map = list.stream()
                .collect(Collectors.groupingBy(Pearson::getAge));
        return map;
    }
}
