package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.temporal.ChronoUnit;

public class Camping implements InCamping {

    //Atributos

    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaTasquesManteniment llistaTasquesManteniment;
    private LlistaAccessos llistaAccessos;

    public Camping(String nom){
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
        this.llistaAccessos = new LlistaAccessos();
    }

    /**
     * Retorna el nom del càmping.
     *
     * @return String
     */
    @Override
    public String getNomCamping() {
        return nom;
    }

    /**
     * Llista els allotjaments segons el seu estat.
     *
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {





        return "";
    }

    /**
     * Llista els accessos segons l'estat indicat.
     *
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "";
    }

    /**
     * Llista les tasques registrades al càmping.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return "";
    }

    /**
     * Afegeix una nova tasca al registre del càmping.
     *
     * @param num           Número identificador de la tasca.
     * @param tipus         Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data          Data en què s'ha registrat la tasca.
     * @param dies          Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {

    }

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     *
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {

    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     *
     * @return El nombre d'accessos accessibles. (int)
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        return 0;
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     *
     * @return La quantitat de metres. (float)
     */
    @Override
    public float calculaMetresTerra() {
        return 0;
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        if (camiDesti == null) {
            throw new ExcepcioCamping("Cami fitxer destí no valid");
        }
        File file = new File(camiDesti);
        FileOutputStream fout = null;
        try {
            //Preparem el fitxer de sortida
            fout = new FileOutputStream(file);

            //Guardem el fitxer
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (FileNotFoundException ex) {
            throw new ExcepcioCamping("Fitxer no trobat");
        } catch (IOException ex) {
            throw new ExcepcioCamping("Problema d'escriptura");
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                throw new ExcepcioCamping("No es pot tancar el fitxer");
            }
        }
    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    @Override
    public void inicialitzaDadesCamping() {

    }
}


