package prog2.model;

public class CamiTerra extends AccesTerra{

    public CamiTerra(String nom, String accessibilitat, boolean estat, long longitud){
        super(nom,accessibilitat,estat,longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
