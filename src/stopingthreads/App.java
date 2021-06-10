package stopingthreads;

import java.util.Random;

public class App {
    public static void main(String args[]){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();

                for(int i=0; i<1E8; i++){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted");
                        break;
                    }
                    Math.sin(r.nextDouble());
                }
            }
        });
        t1.start();

        t1.interrupt();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
