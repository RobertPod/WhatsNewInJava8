package pluralsight.robert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadingTextFiles_MethodFile {

    public static void main(String[] args) {
        Path path = Paths.get("test.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.filter(line -> line.contains("ERROR"))
                    .findFirst()
                    .ifPresent(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }
}
