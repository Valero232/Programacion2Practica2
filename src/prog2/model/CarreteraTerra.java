package prog2.model;

public class CarreteraTerra extends AccesTerra{

    //Atribut
    private long amplada;

    public CarreteraTerra(String nom, boolean estat, long longitud, long amplada){
        super(nom,estat,longitud);
        this.amplada = amplada;
        this.accessibilitat = true;
    }

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    public void setAmplada(long amplada){
        this.amplada = amplada;
    }

    public long getAmplada(){return amplada;}
}
