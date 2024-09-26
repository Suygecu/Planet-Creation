public final class Earth extends PlanetMap implements Planet{

    private static Earth instance;

    private Earth(){


    }


    public static Earth getInstance(){
        if(instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
