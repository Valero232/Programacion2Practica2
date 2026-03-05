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
        if(isEstadaMinima){
            if (allotjamentDisponible()) {
            }
        }
    }

    /**
     * Retorna el número de reserves de la llista.
     *
     * @return el número de reserves.
     */
    @Override
    public int getNumReserves() {
        return 0;
    }




    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        boolean disponible = true;

        Iterator<Reserva> itr = llistaReserves.iterator();
        while(itr.hasNext()){
            Reserva reserva = itr.next();
            if(reserva){
                //Per completar
                LocalDate dataEntradaReservada = reserva.getDataEntrada(),
                LocalDate =dataEntradaReservada = reserva.dataEntrada(),
                if((dataEntrada.isAfter(dataEntradaReservada)))
            }
        }
    }

    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        boolean tmpEstada = false;
        long estada = ChronoUnit.DAYS.between(dataEntrada,dataSortida);

        InAllotjament.Temp temp = Camping.getTemporada(dataEntrada); //crear getTemporada en camping
        long estadaMinima = allotjament.getEstadaMinima(temp);

        if (estada >= estadaMinima){
            tmpEstada = true;
        }
        return tmpEstada;
    }
}
