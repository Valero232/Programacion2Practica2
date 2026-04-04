package prog2.model;

public class BungalowPremium extends Bungalow{

    //Atributs
    private boolean serveisExtra;
    private String codiWifi;


    public BungalowPremium(String nom, String idAllotjament,boolean operatiu, String iluminacio, float mida, int numHabitacions, int capacitat, int numPlaces, boolean terrasa, boolean televisio, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, operatiu, iluminacio, mida, numHabitacions, capacitat, numPlaces, terrasa, televisio, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

   public boolean getServeisExtra(){
    return serveisExtra;
   }
   public String getCodiWifi(){
        return codiWifi;
   }

   public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra = serveisExtra;
   }
   public void setCodiWifi(String codiWifi){
        this.codiWifi = codiWifi;
   }

    @Override
    public boolean correcteFuncionament(){
        boolean correcteFuncionament = false;
        if (super.correcteFuncionament() && codiWifi.length() >= 8 && codiWifi.length()<= 16) correcteFuncionament = true;
        return correcteFuncionament;
    }

    @Override
    public String toString(){
        return super.toString()+"Premium{serveisExtra="+serveisExtra+", codiWifi="+codiWifi+"}";
    }
}
