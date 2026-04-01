package prog2.model;

public class CarreteraTerra extends AccesTerra{

    //Atribut
    private long amplada;

    public CarreteraTerra(String nom, String accessibilitat, boolean estat, long longitud, long amplada){
        super(nom,accessibilitat,estat,longitud);
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public void setAmplada(long amplada){
        this.amplada = amplada;
    }

    public long getAmplada(){return amplada;}
}
