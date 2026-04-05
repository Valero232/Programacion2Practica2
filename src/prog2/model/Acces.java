package prog2.model;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Acces implements InAcces, Serializable {

    //Atributs
    private String nom;
    private boolean estat;
    protected boolean accessibilitat;
    private LlistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();

    /**
     * Crea una nova instància d'Acces amb un nom i un estat operatiu inicial.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true si és operatiu, false en cas contrari).
     */
    public Acces(String nom, boolean estat){
        this.nom = nom;
        this.estat = estat;
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjaments.afegirAllotjament(allotjament);
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() {
        estat = false;
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() {
        estat = true;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return
     */

    public void setNom(String nom){this.nom=nom;}

    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return
     */
    @Override
    public LlistaAllotjaments getAllotjaments() {
        return llistaAllotjaments;
    }

    /**
     * Retorna una representació en format text de l'accés,
     * incloent el nom, l'estat i el tipus d'accessibilitat,
     * així com la llista d'allotjaments associats.
     * @return Cadena de text amb la informació completa de l'accés.
     */
    @Override
    public String toString(){
        return "\nNom= "+nom+", estat="+estat+", accessibilitat="+accessibilitat+".\nAllotjaments:\n"+llistaAllotjaments.llistarAllotjaments("Tots");
    }
}
