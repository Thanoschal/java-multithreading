package sync1;

import java.util.Scanner;

class Processor extends Thread{

    private volatile boolean running = true;

    @Override
    public void run() {
        while(running){
            System.out.println("Hi");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}

public class App {
    public static void main(String[] args){
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press enter to stop...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        proc1.shutdown();
    }
}
