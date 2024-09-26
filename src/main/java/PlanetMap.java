import java.util.HashMap;
import java.util.Map;

public abstract class PlanetMap implements Planet{

    protected Map<String, String> nameByLanguage = new HashMap<>();


    private static String currentLanguage = "en";

    public static void setLanguage (String language){
        currentLanguage = language;
    }

    public void addName(String language, String name){
        nameByLanguage.put(language, name);

    }

    @Override
    public String toString(){
        return nameByLanguage.getOrDefault(currentLanguage, "unknown planet");
    }
}
