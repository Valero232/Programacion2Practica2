package prog2.model;

public abstract class Allotjament implements InAllotjament{

    //Atributs de la clase Allotjament
    private String nom;
    private String idAllotjament;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    //Constructor de la clase
    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA){
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
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
        long tmp =0;
        switch(temp){
            case ALTA:
                tmp = estadaMinimaALTA;
                break;
            case BAIXA:
                tmp = estadaMinimaBAIXA;
                break;
        }
        return tmp;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
       estadaMinimaALTA = estadaMinimaALTA_;
       estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    @Override
    public String toString(){
        long estadaAlta =
        long estadaBaixa =
        return = "Nom="+nom+", Id="+idAllotjament+", estada mínima en temp ALTA: "+estadaMinimaALTA+", estada mínima en temp " +
                "BAIXA: "+estadaMinimaBAIXA+". "
    }

    public abstract boolean correcteFuncionament();

}
