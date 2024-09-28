import Threads.ThreadCollectionPlanet;
import Threads.ThreadCreatePlanet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public  class Main  {



    public static void main(String[] args) throws IOException, InterruptedException {
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








