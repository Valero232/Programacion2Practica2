package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{

    //Atribut
    private long pes;

    public CarreteraAsfalt(String nom, String accessibilitat, boolean estat, long areaAsfalt, long pes){
        super(nom,accessibilitat,estat,areaAsfalt);
        this.pes = pes;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public void setPes(long pes){
        this.pes = pes;
    }

    public long getPes(){return pes;}

}
