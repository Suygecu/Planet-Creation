package Threads;

import Planets.*;

import java.util.ArrayList;



import static Threads.ThreadCreatePlanet.*;


public class ThreadCollectionPlanet implements Runnable {
    private final ArrayList<Planet> planetCollection;

    public ThreadCollectionPlanet() {
        planetCollection = new ArrayList<>();
    }



    @Override
    public void run() {
        Planet newPlanet;
        while ((newPlanet = ThreadCreatePlanet.planetQueue.poll()) != null || isRunning) {
            if (newPlanet != null) {
                planetCollection.add(newPlanet);
                System.out.println("Планета \"" + newPlanet + "\" добавлена в коллекцию");

            }
        }
    }
}