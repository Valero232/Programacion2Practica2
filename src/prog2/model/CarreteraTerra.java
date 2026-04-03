package prog2.model;

public class CarreteraTerra extends AccesTerra{

    //Atribut
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada){
        super(nom,estat,longitud);
        this.amplada = amplada;
        this.accessibilitat = true;
    }

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    public void setAmplada(float amplada){
        this.amplada = amplada;
    }

    public float getAmplada(){return amplada;}
}
