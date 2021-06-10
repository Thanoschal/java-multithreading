package callable;

import java.util.concurrent.*;

public class App {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("Starting...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished");
                return 1;
            }
        });

        executor.shutdown();

        System.out.println("Result is: " + future.get());

        executor.awaitTermination(1, TimeUnit.DAYS);

    }
}
