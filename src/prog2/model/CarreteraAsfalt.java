package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{

    public CarreteraAsfalt(String nom, String accessibilitat, boolean estat, long areaAsfalt){
        super(nom,accessibilitat,estat,areaAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
