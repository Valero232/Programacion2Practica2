package prog2.model;

public class CamiTerra extends AccesTerra{

    public CamiTerra(String nom, boolean estat, long longitud){
        super(nom,estat,longitud);
        this.accessibilitat = false;
    }

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }
}
