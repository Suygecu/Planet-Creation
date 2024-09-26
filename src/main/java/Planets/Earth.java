package Planets;

public final class Earth extends PlanetMap implements Planet {

    private static Earth instance;


    private Earth(){
        addName("ru", EARTH_RU);
        addName("en", EARTH_EN);


    }

    public static Earth getInstance(){
        if(instance == null){
            instance = new Earth();

        }
        return instance;
    }



}
