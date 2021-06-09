package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }
}


public class App {
    public static void main(String[] args){

        //CREATE 2 THREADS IN A THREADPOOL
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //submit tasks to executor
        for(int i=0; i<5; i++){
            executor.submit(new Processor(i));
        }

        //destroy my threadpool manager
        executor.shutdown();
        System.out.println("All tasks submitted");

        //wait for all the threads to terminate
        //if the threads wont terminate after 1 day then terminate by force
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
