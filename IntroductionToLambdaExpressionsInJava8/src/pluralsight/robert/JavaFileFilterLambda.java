package pluralsight.robert;

import java.io.File;
import java.io.FileFilter;

public class JavaFileFilterLambda {

    public static void main(String[] args) {

        FileFilter filter = file -> file.getName().endsWith(".java");

        File dir = new File(
                "c:/Java/WhatsNewInJava8/IntroductionToLambdaExpressionsInJava8/src/pluralsight/robert/");
        File[] javaFiles = dir.listFiles(filter);
        for (File f : javaFiles) {
            System.out.println(f);
        }
    }
}