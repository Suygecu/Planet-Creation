package Planets;

public final class Earth  implements Planet {

    private volatile static Earth instance;


    public  static Earth getInstance(){
        if(instance == null){
            instance = new Earth();

        }
        return instance;
    }

    @Override
    public String toString(){

        return EARTH_EN;
    }



}
