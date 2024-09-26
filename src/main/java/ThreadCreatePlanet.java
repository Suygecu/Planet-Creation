import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

public  class ThreadCreatePlanet implements Runnable {

    static Planet planet;
    static final ConcurrentLinkedQueue<Planet> planetQueue = new ConcurrentLinkedQueue<>();
    static volatile boolean isRunning = true;

    public static boolean isRussian(String input) {
        System.out.println("Проверка ввода: " + input);
        return input.matches(".*[а-яА-Я]+.*");
    }

    public static void createPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine().toLowerCase().trim();


        while (key != null && !(key.equalsIgnoreCase("exist") || key.equalsIgnoreCase("выход"))) {
            if (isRussian(key)) {
                PlanetMap.setLanguage("ru");
            } else {
                PlanetMap.setLanguage("en");
            }

            if (key.equalsIgnoreCase(Planet.SUN_RU) || key.equalsIgnoreCase(Planet.SUN_EN)) {
                planet = Sun.getInstance();
                System.out.println("Я создал " + planet);
            }
            else if (key.equalsIgnoreCase(Planet.EARTH_RU) || key.equalsIgnoreCase(Planet.EARTH_EN)) {
                planet = Earth.getInstance();
                System.out.println("Я создал " + planet);
            }
            else if (key.equalsIgnoreCase(Planet.MERCURY_RU) || key.equalsIgnoreCase(Planet.MERCURY_EN)) {
                planet = Mercury.getInstance();
                System.out.println("Я создал " + planet);
            }
            else if (key.equalsIgnoreCase(Planet.MOON_RU) || key.equalsIgnoreCase(Planet.MOON_EN)) {
                planet = Moon.getInstance();
                System.out.println("Я создал  " + planet);
            }else {
                planet = null;
                System.out.println("Не правильный ввод");

            }
            if (planet != null) {
                planetQueue.add(planet);
            }
            key = reader.readLine().toLowerCase().trim();


        }
        isRunning = false;
    }

    @Override
    public void run() {
        try {
            createPlanet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}