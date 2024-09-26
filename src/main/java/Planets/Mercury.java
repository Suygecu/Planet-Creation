package Planets;

import Planets.Planet;
import Planets.PlanetMap;

public final class Mercury extends PlanetMap implements Planet {

    private static Mercury instance;
    private static int idCounter = 0;

    private Mercury(){
        addName("ru", MERCURY_RU);
        addName("en", MERCURY_EN);
    }

    public static Mercury getInstance(){

        if (instance == null){
            instance = new Mercury();
        }
        return instance;
    }


    public static synchronized int getNextId() {
        return ++idCounter;

    }
}

