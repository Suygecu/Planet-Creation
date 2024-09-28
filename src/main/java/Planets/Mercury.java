package Planets;

public final class Mercury implements Planet {

    private volatile static Mercury instance;

    public static Mercury getInstance(){

        if (instance == null){
            instance = new Mercury();
        }
        return instance;
    }
    @Override
    public String toString(){

        return MERCURY_RU;
    }
}

