package pluralsight.robert;

import java.io.File;
import java.io.FileFilter;

public class JavaFileFilterConcreteClass implements FileFilter {
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}
