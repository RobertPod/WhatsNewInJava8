package pluralsight.robert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadingDirectoryEntries {

    public static void main(String[] args) {
        Path path = Paths.get("c:", "Java");
        try (Stream<Path> stream = Files.list(path)) {
            stream.filter(p -> p.toFile().isDirectory())
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        try (Stream<Path> stream = Files.list(path)) {
            stream.filter(p -> p.toFile().isFile())
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        try (Stream<Path> stream = Files.walk(path, 2)) {
            stream.filter(p -> p.toFile().isDirectory())
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }
}
