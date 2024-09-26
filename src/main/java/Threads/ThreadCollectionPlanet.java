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
        while (isRunning || !planetQueue.isEmpty()) {
            if (!planetQueue.isEmpty()) {
                Planet newPlanet = planetQueue.poll();
                if (newPlanet != null) {
                    planetCollection.add(newPlanet);
                    System.out.println("Планета \"" + newPlanet + "\" добавлена в коллекцию");
                }
            }
        }
        System.out.println("\nКоллекция планет завершена. \nВсего планет: " + planetCollection.size());
        for (Planet p : planetCollection) {
            if(p instanceof Earth)
                System.out.println(IdGenerator.getNextId() + ". " + p);
             if (p instanceof Sun)
                System.out.println(IdGenerator.getNextId() + ". " + p);
             if(p instanceof Mercury)
                System.out.println(IdGenerator.getNextId() + ". " + p);
             if(p instanceof Moon)
                System.out.println(IdGenerator.getNextId() + ". " + p);
        }
    }
}