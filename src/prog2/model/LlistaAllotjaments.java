package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;

import prog2.vista.ExcepcioCamping;

public class LlistaAllotjaments implements InLlistaAllotjaments{

 //Atributs
    private ArrayList<Allotjament> llistaAllotjaments;


  public LlistaAllotjaments(){
      llistaAllotjaments = new ArrayList<Allotjament>();
  }
    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     *
     * @param allotjament Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        llistaAllotjaments = null;
    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        String llista = "";
        while(itr.hasNext()){
            llista += itr.next().toString()+"\n";
        }
        if(llista!=""){
            return llista;
        }
        else{
            throw new ExcepcioCamping("No hi ha cap tasca a la llista");
        }
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     *
     * @return boolean
     */
    @Override
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        while (itr.hasNext()) {
            Allotjament allotjament = itr.next();
            if (allotjament.isOperatiu()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     *
     * @param allotjament
     * @return boolean
     */
    @Override
    public boolean contains(Allotjament allotjament) {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        while (itr.hasNext()) {
            Allotjament allotjament_ = itr.next();
            if (allotjament_ == allotjament) {
                return true;
            }
        }
        return false;
    }
    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     *
     * @param id String amb el id de l'allotjament
     * @return Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        while(itr.hasNext()){
            Allotjament allotjament = itr.next();
            if(allotjament.getId()==id){
                return allotjament;
            }
        }
        throw new ExcepcioCamping("L'allotjament amb id "+id+" no existeix");
    }
}
