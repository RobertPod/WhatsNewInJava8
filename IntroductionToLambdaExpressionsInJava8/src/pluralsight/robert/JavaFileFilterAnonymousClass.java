package pluralsight.robert;

import java.io.File;
import java.io.FileFilter;

public class JavaFileFilterAnonymousClass {

    public static void main(String[] args) {

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        File dir = new File("c:\\Java\\WhatsNewInJava8\\IntroductionToLambdaExpressionsInJava8\\src\\pluralsight\\robert\\");
        File[] javaFiles = dir.listFiles(fileFilter);

        for (File f : javaFiles) {
            System.out.println(f);
        }
    }
}
