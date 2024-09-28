package Planets;

public final class Moon  implements Planet {

    private volatile static Moon instance;



    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();

        }
        return instance;
    }
    @Override
    public String toString(){

        return MOON_EN;
    }
}

