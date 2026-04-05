package prog2.model;

public abstract class AccesAsfalt extends Acces{
    //Atributs
    private float areaAsfalt;

    /**
     * Crea una nova instància d'AccesAsfalt amb un nom, un estat operatiu i una àrea asfaltada.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true si és operatiu, false en cas contrari).
     * @param areaAsfalt Àrea asfaltada associada a l'accés, en metres quadrats.
     */
    public AccesAsfalt(String nom, boolean estat, float areaAsfalt){
        super(nom,estat);
        this.areaAsfalt = areaAsfalt;
    }
    /**
     * Modifica l'àrea asfaltada associada a l'accés.
     * @param areaAsfalt Nou valor de l'àrea asfaltada, en metres quadrats.
     */

    public void setAreaAsfalt(float areaAsfalt){
        this.areaAsfalt = areaAsfalt;
    }
    /**
     * Retorna l'àrea asfaltada associada a l'accés.
     * @return Valor de l'àrea asfaltada en metres quadrats.
     */

    public float getAreaAsfalt(){return areaAsfalt;}

    /**
     * Retorna una representació en format text de l'accés asfaltat,
     * incloent la informació heretada i l'àrea asfaltada.
     * @return Cadena de text amb la informació de l'objecte.
     */

    @Override
    public String toString(){
        return super.toString() + "Àrea asfaltada= "+areaAsfalt+". ";
    }

}
