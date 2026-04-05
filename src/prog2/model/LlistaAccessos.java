package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import prog2.vista.ExcepcioCamping;

public class LlistaAccessos implements InLlistaAccessos, Serializable {


    //Atributs
    private ArrayList<Acces> llistaAcces;


    public LlistaAccessos(){
        llistaAcces = new ArrayList<Acces>();
    }


    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if(llistaAcces.contains(acc)){
            throw new ExcepcioCamping("L'accés "+acc.getNom()+" ja existeix a la llista");
        }
        else{
            llistaAcces.add(acc);
        }
    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() { llistaAcces = new ArrayList<Acces>();}

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     *
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        Iterator<Acces> itr = llistaAcces.iterator();
        String llistat = "";
        boolean buit = true;
        while(itr.hasNext()){
            Acces acces = itr.next();
            if(acces.getEstat()==estat){
                llistat += acces.toString()+"\n";
                buit = false;
            }
        }
        if(buit){throw new ExcepcioCamping("No hi ha accessos en l'estat passat com a paràmetre");}
        return llistat;
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> itr = llistaAcces.iterator();
        boolean buit=true;
        while(itr.hasNext()){
            Acces acces = itr.next();
            acces.tancarAcces();
            if(acces.getAllotjaments().containsAllotjamentOperatiu()){
                acces.obrirAcces();
            }
            buit=false;
        }
        if(buit){throw new ExcepcioCamping("La llista d'accessos està buida");};
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     *
     * @return int
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        Iterator<Acces> itr = llistaAcces.iterator();
        boolean buit=true;
        int numAccessosNoAccessibles = 0;
        while(itr.hasNext()){
            if(!(itr.next().isAccessibilitat())){
                numAccessosNoAccessibles++;
            }
            buit = false;
        }
        if(buit){ throw new ExcepcioCamping("La llista d'accessos està buida");}
        return numAccessosNoAccessibles;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     *
     * @return float amb els metres totals.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres = 0.0f;
        boolean minimo = false;
        Iterator<Acces> itr = llistaAcces.iterator();
        while(itr.hasNext()) {
            Acces acces = itr.next();
            if (acces instanceof AccesTerra){
                metres += ((AccesTerra)acces).getLongitud();
                minimo = true;
            }
        }
        if (minimo){
            return metres;
        }
        else{
            throw new ExcepcioCamping("No hi ha Accesos tipus terra per sumar longituds");
        }
    }
}
