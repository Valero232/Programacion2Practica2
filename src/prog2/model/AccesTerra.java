package prog2.model;

public abstract class AccesTerra extends Acces{
    //Atributs
    private long longitud;

    public AccesTerra(String nom, String accessibilitat, boolean estat, long longitud){
        super(nom,accessibilitat,estat);
        this.longitud = longitud;
    }

    public void setLongitud(long longitud){
        this.longitud = longitud;
    }

    public long getLongitud(){return longitud;}

}
