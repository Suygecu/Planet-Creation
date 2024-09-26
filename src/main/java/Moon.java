public final class Moon extends PlanetMap implements Planet {

    private static Moon instance;

    private Moon() {
        addName("ru", MERCURY_RU);
        addName("en", MERCURY_EN);

    }

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();

        }
        return instance;
    }

}
