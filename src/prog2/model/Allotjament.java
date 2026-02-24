package prog2.model;

public abstract class Allotjament implements InAllotjament{

    //Atributs de la clase Allotjament
    private String nom;
    private String idAllotjament;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    //Constructor de la clase
    public Allotjament(String nom, String idAllotjament){

    }

    //getter i setter nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // getter i setter id
    public String getId(){
        return idAllotjament;
    }

    public void setId(String id) {
        idAllotjament = id;
    }

    public long getEstadaMinima(Temp temp){
        if (temp == Temp.BAIXA){
            return estadaMinimaBAIXA;
        }
        return estadaMinimaALTA;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
       estadaMinimaALTA = estadaMinimaALTA_;
       estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    public abstract boolean correcteFuncionament();

}
