package prog2.model;

public abstract class AccesAsfalt extends Acces{
    //Atributs
    private float areaAsfalt;

    public AccesAsfalt(String nom, boolean estat, float areaAsfalt){
        super(nom,estat);
        this.areaAsfalt = areaAsfalt;
    }

    public void setAreaAsfalt(float areaAsfalt){
        this.areaAsfalt = areaAsfalt;
    }

    public float getAreaAsfalt(){return areaAsfalt;}

}
