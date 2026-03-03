package prog2.model;

public class Bungalow extends Casa{
    //Atributs
    private int numPlaces;
    private boolean aireFred;
    private boolean terrasa;
    private boolean televisio;

    public Bungalow(String nom, String idAllotjament, String mida, int numHabitacions, int capacitat, int numPlaces, boolean terrasa, boolean televisio, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, mida, numHabitacions, capacitat);
        this.terrasa = terrasa;
        this.televisio = televisio;
        this.aireFred = aireFred;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public boolean getAireFred(){
        return aireFred;
    }
    public boolean getTerrasa(){
        return terrasa;
    }
    public boolean getTelevisio(){
        return televisio;
    }


    public void setNumPlaces(int numPlaces){
        this.numPlaces = numPlaces;
    }

    public void setAireFred(boolean aireFred){
        this.aireFred = aireFred;
    }

    public void setTerrasa(boolean terrasa){
        this.terrasa = terrasa;
    }
    public void setTelevisio(boolean televisio){
        this.televisio = televisio;
    }


    @Override
    public boolean correcteFuncionament() {
        //Si té aire fred significa que funciona correctament
        boolean funcionamentCorrecte = false;
        if (aireFred) funcionamentCorrecte = true;
        return funcionamentCorrecte;
    }
}
