package prog2.model;

import java.time.LocalDate;

public class Reserva implements InReserva{

    //Atributs
    private Client client;
    private Allotjament allotjament;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client, LocalDate diaEntrada, LocalDate diaSortida){
        this.client = client;
        this.allotjament = allotjament;
        this.dataEntrada = diaEntrada;
        this.dataSortida = diaSortida;
    }

    @Override
    public Allotjament getAllotjament_() {
        return this.allotjament;
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public LocalDate getDataEntrada() {
        return this.dataEntrada;
    }

    @Override
    public LocalDate getDataSortida() {
        return this.dataSortida;
    }

    @Override
    public void setAllotjament_(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    @Override
    public void setClient(Client client_) {
        this.client = client_;
    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada_) {
        this.dataEntrada = dataEntrada_;

    }

    @Override
    public void setDataSortida(LocalDate dataSortida_) {
        this.dataSortida = dataSortida_;
    }
}
