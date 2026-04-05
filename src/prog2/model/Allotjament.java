package prog2.model;

import java.io.Serializable;

public abstract class Allotjament implements InAllotjament, Serializable {

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

    //-----------------------------------------------------------Practica 2 -------------------------------------------------------
    @Override
    public String toString(){
      return "Nom="+nom+", Id="+idAllotjament+", estada mínima en temp ALTA: "+estadaMinimaALTA+", estada mínima en temp " + "BAIXA: "+estadaMinimaBAIXA+", operatiu: "+operatiu+", il·luminació:"+iluminacio+".";
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

    /**
     * Tanca l'allotjament i actualitza el seu estat intern segons la tasca de manteniment.
     * @param tasca Objecte TascaManteniment que conté la nova configuració d'il·luminació.
     */
    @Override
    public void tancarAllotjament(TascaManteniment tasca){
        operatiu = false;
        iluminacio = tasca.getIluminacioAllotjament();
    }
    /**
     * Obre l'allotjament i restableix la il·luminació al valor per defecte.
     */

    @Override
    public void obrirAllotjament(){
        operatiu = true;
        iluminacio = "100%";
    }
    /**
     * Indica si l'allotjament es troba operatiu.
     * @return true si l'allotjament està operatiu, false en cas contrari.
     */

    public boolean isOperatiu(){
        return operatiu;
    }
}
