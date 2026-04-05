package prog2.model;

public class CamiAsfalt extends AccesAsfalt{

    /**
     * Crea una nova instància de CamiAsfalt amb un nom, un estat operatiu
     * i una àrea asfaltada determinada. Per defecte, un camí asfaltat no és accessible.
     * @param nom Nom identificador del camí.
     * @param estat Estat inicial del camí (true si és operatiu, false en cas contrari).
     * @param areaAsfalt Àrea asfaltada associada al camí, en metres quadrats.
     */

    public CamiAsfalt(String nom, boolean estat, float areaAsfalt){
        super(nom,estat,areaAsfalt);
        this.accessibilitat = false;
    }

    /**
     * Indica si el camí asfaltat és accessible.
     * @return false, ja que un CamiAsfalt no és accessible per definició.
     */

    @Override
    public boolean isAccessibilitat(){
        return accessibilitat;
    }
}
