package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{

    //Atribut
    private float pes;

    public CarreteraAsfalt(String nom, boolean estat, float areaAsfalt, float pes){
        super(nom,estat,areaAsfalt);
        this.pes = pes;
        this.accessibilitat = true;
    }

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    public void setPes(float pes){
        this.pes = pes;
    }

    public float getPes(){return pes;}

}
