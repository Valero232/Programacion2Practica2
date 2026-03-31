package prog2.model;

public abstract class AccesAsfalt extends Acces{
    //Atributs
    private long areaAsfalt;

    public AccesAsfalt(String nom, String accessibilitat, boolean estat, long areaAsfalt){
        super(nom,accessibilitat,estat);
        this.areaAsfalt = areaAsfalt;
    }
}
