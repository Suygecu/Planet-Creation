package Planets;

public  class Sun  implements Planet {
    private volatile static Sun instance;

    public static Sun getInstance(){
        if(instance == null){
            instance = new Sun();
        }
        return instance;
    }
    @Override
    public String toString(){

        return SUN_EN;
    }

}



