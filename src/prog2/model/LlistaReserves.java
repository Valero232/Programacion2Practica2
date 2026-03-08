package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

public class LlistaReserves implements InLlistaReserves{

    // Atributs

    private ArrayList <Reserva> llistaReserves;


    // constructor
    LlistaReserves(){
        llistaReserves = new ArrayList<Reserva>();
    }

    public void setLlistaReserves(ArrayList<Reserva> llistaReserves) {
        this.llistaReserves = llistaReserves;
    }

    public ArrayList<Reserva> getLlistaReserves() {
        return llistaReserves;
    }

    /**
     * Comprova que l'estada que es demani sigui més llarga o igual que l'estada mínima.
     * Comprova que l'allotjament estigui disponible pels dies indicats.
     * En cas afirmatiu, crea la reserva i l’afegeix a la llista de reserves del camping.
     * En cas negatiu, llança una excepció de tipus ExceptionReserva amb el missatge d'error.
     *
     * @param allotjament
     * @param client
     * @param dataEntrada
     * @param dataSortida
     * @throws ExcepcioReserva
     */
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        if(isEstadaMinima(allotjament, dataEntrada, dataSortida)){
            if (allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
                Reserva reservaActual = new Reserva(allotjament, client, dataEntrada, dataSortida);
                llistaReserves.add(reservaActual);
            }
            else{
                throw new ExcepcioReserva("L’allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada "+ dataEntrada +" pel client " + client.getNom() +" amb DNI: " + client.getDni() +".");
            }
        }
        else{
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
        }
    }

    /**
     * Retorna el número de reserves de la llista.
     *
     * @return el número de reserves.
     */
    @Override
    public int getNumReserves() {
        int contadorTmp = 0;
        Iterator<Reserva> itr = llistaReserves.iterator();
        while (itr.hasNext()) {
            Reserva reserva = itr.next();
            contadorTmp++;
        }
        return contadorTmp;
    }


    /**
     * Comprova si un allotjament està disponible per a un període determinat.
     * Verifica que no hi hagi cap reserva existent que solapi amb les dates sol·licitades.
     *
     * @param allotjament L'allotjament que es vol comprovar
     * @param dataEntrada La data d'entrada sol·licitada
     * @param dataSortida La data de sortida sol·licitada
     * @return true si l'allotjament està disponible, false si hi ha alguna reserva que solapi
     */

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

        Iterator<Reserva> itr = llistaReserves.iterator();
        while(itr.hasNext()){
            Reserva reserva = itr.next();
            if(reserva.getAllotjament_()==allotjament){
                //Per completar
                LocalDate dataEntradaReservada = reserva.getDataEntrada();
                LocalDate dataSortidaReservada = reserva.getDataSortida();
                if((dataEntrada.isBefore(dataSortidaReservada) && dataEntrada.isAfter(dataEntradaReservada)) ||
                (dataSortida.isBefore(dataSortidaReservada) && dataSortida.isAfter(dataEntradaReservada))){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Comprova que la durada de l'estada sigui igual o superior a l'estada mínima
     * requerida per l'allotjament segons la temporada de la data d'entrada.
     *
     * @param allotjament L'allotjament pel qual es vol comprovar l'estada mínima
     * @param dataEntrada La data d'entrada de la reserva
     * @param dataSortida La data de sortida de la reserva
     * @return true si l'estada compleix el mínim requerit, false en cas contrari
     */

    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        boolean tmpEstada = false;
        long estada = ChronoUnit.DAYS.between(dataEntrada,dataSortida);

        InAllotjament.Temp temp = Camping.getTemporada(dataEntrada);
        long estadaMinima = allotjament.getEstadaMinima(temp);

        if (estada >= estadaMinima){
            tmpEstada = true;
        }
        return tmpEstada;
    }
}
