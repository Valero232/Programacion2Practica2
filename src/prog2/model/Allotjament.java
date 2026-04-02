package prog2.model;

public abstract class Allotjament implements InAllotjament{

    //Atributs de la clase Allotjament
    private String nom;
    private String idAllotjament;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean operatiu;
    String iluminacio;

    //Constructor de la clase
    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio){
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;
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
      return "Nom="+nom+", Id="+idAllotjament+", estada mínima en temp ALTA: "+estadaMinimaALTA+", estada mínima en temp " + "BAIXA: "+estadaMinimaBAIXA+".";
    }

    public abstract boolean correcteFuncionament();

    public void setIluminacio(String iluminacio){
        this.iluminacio = iluminacio;
    }

    public String getIluminacio(){return iluminacio;}

    public void setOperatiu(boolean operatiu){
        this.operatiu = operatiu;
    }

    public boolean getOperatiu(){return operatiu;}

    @Override
    public void tancarAllotjament(TascaManteniment tasca){
        operatiu = false;
        iluminacio = tasca.getIluminacioAllotjament();
    }

    @Override
    public void obrirAllotjament(){
        operatiu = true;
        iluminacio = "100%";
    }

    public boolean isOperatiu(){

    }

}
