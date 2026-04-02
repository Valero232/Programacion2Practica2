package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{

    //Atribut
    private long pes;

    public CarreteraAsfalt(String nom, boolean estat, long areaAsfalt, long pes){
        super(nom,estat,areaAsfalt);
        this.pes = pes;
        this.accessibilitat = true;
    }

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    public void setPes(long pes){
        this.pes = pes;
    }

    public long getPes(){return pes;}

}
