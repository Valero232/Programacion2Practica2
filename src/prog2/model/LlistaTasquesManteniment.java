package prog2.model;

import java.util.ArrayList;
import prog2.vista.ExcepcioCamping;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment{

    //Atributs
    private ArrayList<TascaManteniment> llistaTascaManteniment;


    public LlistaTasquesManteniment(){
        llistaTascaManteniment = new ArrayList<TascaManteniment>();
    }

    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
     * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
     *
     * @param num         Número d'identificació de la tasca.
     * @param tipus       Aquest String permet crear el enum TipusTascaManteniment
     * @param allotjament Allotjament on s'afegeix la tasca
     * @param data        Data quan genera la tasca
     * @param dies        Número de dies esperats per completar la tasca
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
       if(!allotjament.isOperatiu()){
           throw new ExcepcioCamping("Allotjament no operatiu");
       }
       else {
        try {
            TascaManteniment.TipusTascaManteniment tipus1 = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
            TascaManteniment tascaManteniment = new TascaManteniment(num, tipus1, allotjament, data, dies);
            allotjament.tancarAllotjament(tascaManteniment);
            llistaTascaManteniment.add(tascaManteniment);
        }
        catch (IllegalArgumentException e){
            throw new ExcepcioCamping("Tipus de tasca no existeix");
        }
       }
    }

    /**
     * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     *
     * @param tasca Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        Iterator<TascaManteniment> itr = llistaTascaManteniment.iterator();
        boolean trobat = false;
        while(itr.hasNext()){
            TascaManteniment tascaManteniment = itr.next();
            if(tascaManteniment==tasca){
                llistaTascaManteniment.remove(tascaManteniment);
                tascaManteniment.getAllotjament().obrirAllotjament();
                trobat = true;
            }
        }
        if(!trobat){
            throw new ExcepcioCamping("Tasca manteniment no trobada");
        }

    }

    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        Iterator<TascaManteniment> itr = llistaTascaManteniment.iterator();
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
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     *
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */
    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        Iterator<TascaManteniment> itr = llistaTascaManteniment.iterator();
        while(itr.hasNext()){
            TascaManteniment tascaManteniment = itr.next();
            if(tascaManteniment.getNum()==num){
                return tascaManteniment;
            }
        }
        throw new ExcepcioCamping("La tasca amb el número "+num+" no existeix");
    }
}
