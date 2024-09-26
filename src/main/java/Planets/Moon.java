package Planets;

public final class Moon extends PlanetMap implements Planet {

    private static Moon instance;
    private static int idCounter = 0;

    private Moon() {
        addName("ru", MOON_RU);
        addName("en", MOON_EN);

    }

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();

        }
        return instance;
    }


    public static synchronized int getNextId() {
        return ++idCounter;

    }

}

