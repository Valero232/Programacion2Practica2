package prog2.model;

public class BungalowPremium extends Bungalow{

    //Atributs
    private boolean serveisExtra;
    private String codiWifi;


    public BungalowPremium(String nom, String idAllotjament, String mida, int numHabitacions, int capacitat, int numPlaces, boolean terrasa, boolean televisio, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, mida, numHabitacions, capacitat, numPlaces, terrasa, televisio, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }



    @Override
    public boolean correcteFuncionament(){
        boolean correcteFuncionament = false;
        if (super.correcteFuncionament() && codiWifi.length() >= 8 && codiWifi.length()<= 16) correcteFuncionament = true;
        return correcteFuncionament;
    }
}
