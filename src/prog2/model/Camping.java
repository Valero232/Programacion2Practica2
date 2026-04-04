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
        return llistaAllotjaments.llistarAllotjaments(estat);
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
        boolean estat;
        if(infoEstat.equals("Obert")){estat = true;}
        else if(infoEstat.equals("Tancat")){estat = false;}
        else{throw new ExcepcioCamping("L'estat indicat no és correcte");}
        return llistaAccessos.llistarAccessos(estat);
    }

    /**
     * Llista les tasques registrades al càmping.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
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
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     *
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(num);
        llistaTasquesManteniment.completarTascaManteniment(tasca);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     *
     * @return El nombre d'accessos accessibles. (int)
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        return llistaAccessos.calculaAccessosNoAccessibles();
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     *
     * @return La quantitat de metres. (float)
     */
    @Override
    public float calculaMetresTerra() {
        return llistaAccessos.calculaMetresTerra();
    }

    /**
     * Carrega l'estat d'un càmping des d'un fitxer.
     * @param camiOrigen Ruta del fitxer d'origen.
     * @return Una instància de la classe Camping carregada des del fitxer.
     * @throws ExcepcioCamping
     */
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        if(camiOrigen == null){
            throw new ExcepcioCamping("Cami fitxer origen no valid");
        }
        File file = new File(camiOrigen);
        FileInputStream fin = null;
        try{
            fin = new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(fin);
            Camping camping = (Camping) ois.readObject();
            return camping;
        } catch(IOException ex) {
            throw new ExcepcioCamping("Problema de lectura");
        } catch(ClassNotFoundException ex){
            throw new ExcepcioCamping("Classe no trobada");
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException ex) {
                throw new ExcepcioCamping("No es pot tancar el fitxer");
            }
        }
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


