package prog2.model;

public class Parcela extends Allotjament {
    //Atributs
    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, boolean connexioElectrica){
        super(nom,idAllotjament,4,2, operatiu, iluminacio);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida(){
        return this.mida;
    }

    public boolean getConnexioElectrica(){
        return this.connexioElectrica;
    }

    public void setMida(float mida){
        this.mida = mida;
    }
    public void setConnexioElectrica(boolean ConnexioElectrica){
        this.connexioElectrica = ConnexioElectrica;
    }

    @Override
    public boolean correcteFuncionament(){
        //Si la parcel·la te un punt de connexió elèctrica això significa que funciona correctament.
        boolean correcteFuncionament = false;
        if (connexioElectrica){
            correcteFuncionament = true;
        }
        return correcteFuncionament;
    }

    @Override
    public String toString(){
        return super.toString()+"Parcela{mida="+mida+", connexioElectrica="+connexioElectrica+"}";
    }
}
