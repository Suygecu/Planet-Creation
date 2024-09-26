public final class Mercury extends PlanetMap implements Planet{

    private static Mercury instance;

    private Mercury(){
    }
    public static Mercury getInstance(){

        if (instance == null){
            instance = new Mercury();
        }
        return instance;
    }
}
