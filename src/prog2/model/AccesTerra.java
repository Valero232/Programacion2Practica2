package prog2.model;

public abstract class AccesTerra extends Acces{
    //Atributs
    private long longitud;

    public AccesTerra(String nom, boolean estat, long longitud){
        super(nom,estat);
        this.longitud = longitud;
    }

    public void setLongitud(long longitud){
        this.longitud = longitud;
    }

    public long getLongitud(){return longitud;}

}
