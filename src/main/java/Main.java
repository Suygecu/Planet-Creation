import Threads.ThreadCollectionPlanet;
import Threads.ThreadCreatePlanet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public  class Main  {



    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread = new Thread(new ThreadCreatePlanet());
        thread.start();


        Thread thread1 = new Thread(new ThreadCollectionPlanet());
        Thread thread2 = new Thread(new ThreadCollectionPlanet());
        Thread thread3 = new Thread(new ThreadCollectionPlanet());
        Thread thread4 = new Thread(new ThreadCollectionPlanet());
        Thread thread5 = new Thread(new ThreadCollectionPlanet());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        try{
            thread.join();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }
    }


}








