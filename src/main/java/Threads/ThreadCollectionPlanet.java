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
        System.out.println("Коллекция планет завершена. \nВсего планет: " + planetCollection.size());
        System.out.println("Cписок планет в коллекции");
        for (Planet p : planetCollection) {
            if(p instanceof Earth)
                System.out.println(Earth.getNextId() + "." + planet.toString());
             if (p instanceof Sun)
                System.out.println(Sun.getNextId() + "." + planet.toString());
             if(p instanceof Mercury)
                System.out.println(Mercury.getNextId() + "." + planet.toString());
             if(p instanceof Moon)
                System.out.println(Moon.getNextId() + "." + planet.toString());
        }
    }
}