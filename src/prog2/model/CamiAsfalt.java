package prog2.model;

public class CamiAsfalt extends AccesAsfalt{

    public CamiAsfalt(String nom, String accessibilitat, boolean estat, long areaAsfalt){
        super(nom,accessibilitat,estat,areaAsfalt);
    }

    @Override
    public boolean isAccessibilitat(){
        return false;
    }
}
