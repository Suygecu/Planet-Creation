import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.concurrent.ConcurrentLinkedQueue;

public  class Main  {

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(new ThreadCreatePlanet());
        thread.start();

        Thread thread1 = new Thread(new ThreadCollectionPlanet());
        thread1.start();


        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}








