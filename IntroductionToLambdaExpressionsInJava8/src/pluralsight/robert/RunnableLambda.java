package pluralsight.robert;

public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnableLambda = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(
                        "Hello worrld from thread [" +
                                Thread.currentThread().getName() +
                                "]");
            }
        };

        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();
    }
}

