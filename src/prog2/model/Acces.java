package prog2.model;

public abstract class Acces implements InAcces{

    //Atributs
    private String nom;
    private String accessibilitat;
    private boolean estat;
    private llistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();

    public Acces(String nom, String accessibilitat, boolean estat){
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() {

    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() {

    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() {
        return "";
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return
     */
    @Override
    public boolean getEstat() {
        return false;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return
     */
    @Override
    public LlistaAllotjaments getAllotjaments() {
        return null;
    }
}
