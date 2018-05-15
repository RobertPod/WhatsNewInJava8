package pluralsight.robert;

import java.io.File;
import java.io.FileFilter;

public class RunnableAnonymousClass {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(
                            "Hello worrld from thread [" +
                                    Thread.currentThread().getName() +
                                    "]");
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        t.join();
    }
}

