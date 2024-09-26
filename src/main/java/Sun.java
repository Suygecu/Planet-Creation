public  class Sun extends PlanetMap implements Planet  {
    private static Sun instance;

    private Sun(){
        addName("ru", SUN_RU);
        addName("en", SUN_EN);

    }



    public static Sun getInstance(){
        if(instance == null){
            instance = new Sun();
        }
        return instance;
    }

}


