package Threads;

import Planets.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


import static Threads.ThreadCreatePlanet.*;


public class ThreadCollectionPlanet implements Runnable {
    private  static final Map<Planet, Integer> planetCollection = new ConcurrentHashMap<>();
    private  static final int THREAD_COLLECTION_SLEEP = 1;


    public void threadSleepCollection (Thread thread) throws InterruptedException {
        TimeUnit.SECONDS.sleep(THREAD_COLLECTION_SLEEP);

    }

    @Override
    public  void run() {
        Planet newPlanet;
        while ((newPlanet = planetQueue.poll()) != null || isRunning) {
            try {
                threadSleepCollection(Thread.currentThread());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + "прерван");
                break;
            }
            if (newPlanet != null) {
                synchronized (planetCollection) {
                    planetCollection.put(newPlanet, planetCollection.getOrDefault(newPlanet, 0) + 1);
                    System.out.println(Thread.currentThread().getName() + " Планета \""
                            + newPlanet + "\" добавлена в коллекцию " + planetCollection.get(newPlanet) + " раз");
                }
            }
        }
    }
}