package prog2.model;

public class CamiAsfalt extends AccesAsfalt{

    public CamiAsfalt(String nom, boolean estat, long areaAsfalt){
        super(nom,estat,areaAsfalt);
        this.accessibilitat = false;
    }

    @Override
    public boolean isAccessibilitat(){
        return accessibilitat;
    }
}
