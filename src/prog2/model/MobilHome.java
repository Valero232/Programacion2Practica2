package prog2.model;

public class MobilHome extends Casa{
    //Atributs
    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String idAllotjament,boolean operatiu, String iluminacio,float mida, int numHabitacions, int capacitat, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3,operatiu,iluminacio, mida, numHabitacions, capacitat);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean getTerrassaBarbacoa(){
        return terrassaBarbacoa;
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        boolean correcteFuncionament = false;
        if(terrassaBarbacoa){
            correcteFuncionament = true;
        }
        return correcteFuncionament;
    }

    @Override
    public String toString(){
        return super.toString()+"Mobil-Home{terrassaBarbacoa="+terrassaBarbacoa+"}";
    }
}
