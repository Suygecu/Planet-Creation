package Threads;

import Planets.*;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class ThreadCreatePlanet implements Runnable {

    static Planet planet;
    static ConcurrentLinkedQueue<Planet> planetQueue = new ConcurrentLinkedQueue<>();
    static volatile boolean isRunning = true;
    private int randomNumberMax = 10;

    public static final int TIME_SLEEP = 1;

    public int generationRandomNumber() {

        return (int) Math.floor(Math.random() * randomNumberMax);

    }


    public static void threadSleep(Thread thread) throws InterruptedException {
        TimeUnit.SECONDS.sleep(TIME_SLEEP);
    }


    @Override
    public void run() {
        try {
            createPlanet();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + "прерван");
        }
    }


    public void createPlanet() throws InterruptedException {
        while (isRunning) {
            threadSleep(Thread.currentThread());

            int resultRandomNumber = generationRandomNumber();
            if (resultRandomNumber < 3) {
                planet = Moon.getInstance();
                System.out.println(Thread.currentThread().getName() + " create " + planet);
            } else if (resultRandomNumber < 5 && resultRandomNumber > 3) {
                planet = Earth.getInstance();
                System.out.println(Thread.currentThread().getName() + " create " + planet);
            } else if (resultRandomNumber < 7 && resultRandomNumber > 5) {
                planet = Mercury.getInstance();
                System.out.println(Thread.currentThread().getName() + " create " + planet);
            } else if (resultRandomNumber < 10 && resultRandomNumber > 7) {
                planet = Sun.getInstance();
                System.out.println(Thread.currentThread().getName() + " create " + planet);
            } else {
                planet = null;
            }
            if (planet != null) {
                planetQueue.add(planet);
                System.out.println(Thread.currentThread().getName() + " add planet " + planet);
            }
        }
        isRunning = false;

    }
}


