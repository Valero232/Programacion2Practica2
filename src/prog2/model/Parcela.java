package prog2.model;

public class Parcela extends Allotjament {
    //Atributs
    private float mida;
    private boolean connexio;

    public Parcela(String nom, String idAllotjament, float mida, boolean connexio){
        super(nom,idAllotjament,4,2);
        this.mida = mida;
        this.connexio = connexio;
    }

    public float getMida(){
        return this.mida;
    }

    public boolean getConnexio(){
        return this.connexio;
    }

    public void setMida(float mida){
        this.mida = mida;
    }

    public void setConnexio(boolean connexio){
        this.connexio = connexio;
    }

    @Override
    public boolean correcteFuncionament(){
        //Si la parcel·la te un punt de connexió elèctrica això significa que funciona correctament.
        return this.connexio;
    }
}
