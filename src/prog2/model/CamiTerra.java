package prog2.model;

public class CamiTerra extends AccesTerra{

    /**
     * Crea una nova instància de CamiTerra amb un nom, un estat operatiu
     * i una longitud determinada. Per defecte, un camí de terra no és accessible.
     * @param nom Nom identificador del camí.
     * @param estat Estat inicial del camí (true si és operatiu, false en cas contrari).
     * @param longitud Longitud del tram de terra associat al camí, en metres.
     */
    public CamiTerra(String nom, boolean estat, float longitud){
        super(nom,estat,longitud);
        this.accessibilitat = false;
    }

    /**
     * Indica si el camí de terra és accessible.
     * @return false, ja que un CamiTerra no és accessible per definició.
     */
    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }
}
