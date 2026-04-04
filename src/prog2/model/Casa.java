package prog2.model;

public abstract class Casa extends Allotjament{
    //Atributs
    private float mida;
    private int numHabitacions;
    private int capacitat;

    public Casa(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio, float mida, int numHabitacions, int capacitat){
        super(nom,idAllotjament,estadaMinimaALTA,estadaMinimaBAIXA,operatiu,iluminacio);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.capacitat = capacitat;
    }

    public String getMida(){
        return this.mida;
    }

    public int getNumHabitacions(){
        return this.numHabitacions;
    }

    public int getCapacitat(){
        return this.capacitat;
    }

    public void setMida(String mida){
        this.mida = mida;
    }

    public void setNumHabitacions(int numHabitacions){
        this.numHabitacions = numHabitacions;
    }

    public void setCapacitat(int capacitat){
        this.capacitat = capacitat;
    }

    @Override
    public String toString(){
        return super.toString()+" Casa{mida="+mida+", numHabitacions="+numHabitacions+", capacitat="+capacitat+"}";
    }
}
