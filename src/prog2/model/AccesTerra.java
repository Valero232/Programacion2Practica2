package prog2.model;

public abstract class AccesTerra extends Acces{
    //Atributs
    private float longitud;

    /**
     * Crea una nova instància d'AccesTerra amb un nom, un estat operatiu i una longitud determinada.
     * @param nom Nom identificador de l'accés.
     * @param estat Estat inicial de l'accés (true si és operatiu, false en cas contrari).
     * @param longitud Longitud del tram de terra associat a l'accés, en metres.
     */
    public AccesTerra(String nom, boolean estat, float longitud){
        super(nom,estat);
        this.longitud = longitud;
    }
    /**
     * Modifica la longitud del tram de terra associat a l'accés.
     * @param longitud Nou valor de la longitud, en metres.
     */

    public void setLongitud(float longitud){
        this.longitud = longitud;
    }
    /**
     * Retorna la longitud del tram de terra associat a l'accés.
     * @return Longitud en metres.
     */

    public float getLongitud(){return longitud;}

    /**
     * Retorna una representació en format text de l'accés de terra,
     * incloent la informació heretada i la longitud del tram.
     * @return Cadena de text amb la informació de l'objecte.
     */
    @Override
    public String toString(){
        return super.toString() + "Longitud= "+longitud+". ";
    }
}
