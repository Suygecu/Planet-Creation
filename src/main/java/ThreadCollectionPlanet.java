import java.util.ArrayList;



public class ThreadCollectionPlanet implements Runnable {
    private final ArrayList<Planet> planetCollection;

    public ThreadCollectionPlanet() {
        planetCollection = new ArrayList<>();
    }

    @Override
    public void run() {
        while (Main.isRunning || !Main.planetQueue.isEmpty()) {
            if (!Main.planetQueue.isEmpty()) {
                Planet newPlanet = Main.planetQueue.poll();
                if (newPlanet != null) {
                    planetCollection.add(newPlanet);
                    System.out.println("Планета \"" + newPlanet + "\" добавлена в коллекцию");
                }
            }
        }
        System.out.println("Коллекция планет завершена. \nВсего планет: " + planetCollection.size());
        System.out.println("Cписок планет в коллекции");
        for (Planet p : planetCollection) {
            System.out.println(p);
        }
    }
}