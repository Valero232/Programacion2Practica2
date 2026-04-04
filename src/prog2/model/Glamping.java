package prog2.model;

public class Glamping extends Casa{

//Atributs
    private String tipus;
    private boolean casaPerMascotes;

    public Glamping(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, int numHabitacions, int capacitat, String tipus, boolean casaPerMascotes) {
        super(nom, idAllotjament, 3, 3, operatiu, iluminacio, mida, numHabitacions, capacitat);
        this.tipus = tipus;
        this.casaPerMascotes = casaPerMascotes;
    }

    public String getTipus(){
        return tipus;
    }
    public boolean getCasaPerMascotes(){
        return casaPerMascotes;
    }

    public void setTipus(String tipus){
        this.tipus = tipus;
    }
    public void setCasaPerMascotes(boolean casaPerMascotes){
        this.casaPerMascotes = casaPerMascotes;
    }

    @Override
    public boolean correcteFuncionament() {
        boolean correcteFuncionament = false;
        if(casaPerMascotes) correcteFuncionament = true;
        return correcteFuncionament;
    }

    @Override
    public String toString(){
        return super.toString()+"Glamping{tipus="+tipus+", casaPerMascotes="+casaPerMascotes+"}";
    }
}
