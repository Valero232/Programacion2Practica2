package prog2.model;

public class CarreteraTerra extends AccesTerra{

    public CarreteraTerra(String nom, String accessibilitat, boolean estat, long longitud){
        super(nom,accessibilitat,estat,longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
