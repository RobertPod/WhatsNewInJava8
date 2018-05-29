package pluralsight.robert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadingTextFiles {

    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     new File("test.txt")))) {
            Stream<String> stream = reader.lines();
            stream.filter(line -> line.contains("ERROR"))
                    .findFirst()
                    .ifPresent(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }
}
