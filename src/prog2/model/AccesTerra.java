package prog2.model;

public abstract class AccesTerra extends Acces{
    //Atributs
    private float longitud;

    public AccesTerra(String nom, boolean estat, float longitud){
        super(nom,estat);
        this.longitud = longitud;
    }

    public void setLongitud(float longitud){
        this.longitud = longitud;
    }

    public float getLongitud(){return longitud;}

    @Override
    public String toString(){
        return super.toString() + "Longitud= "+longitud+". ";
    }
}
