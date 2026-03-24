package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.temporal.ChronoUnit;

public class Camping implements InCamping {

    //Atributos

    private String nom;
    private ArrayList<Allotjament> listaAllotjament;
    private ArrayList<Client> listaClient;
    private LlistaReserves llistaReserves = new LlistaReserves();


    public Camping(String nom){
        this.nom = nom;
        this.listaAllotjament = new ArrayList<Allotjament>();
        this.listaClient = new ArrayList<Client>();
    }

    /**
     * Determina la temporada (ALTA o BAIXA) en funció de la data d'entrada proporcionada.
     * La temporada alta comprèn des del 21 de març fins al 20 de setembre (ambdós inclosos).
     * La temporada baixa comprèn la resta de l'any.
     *
     * @param dataEntrada La data per a la qual es vol determinar la temporada
     * @return InAllotjament.Temp.ALTA si la data està dins del període de temporada alta (21/03 - 20/09),
     *         InAllotjament.Temp.BAIXA en cas contrari
     */

    public static InAllotjament.Temp getTemporada(LocalDate dataEntrada) {
        int dia = dataEntrada.getDayOfMonth();
        int mes = dataEntrada.getMonthValue();
        if(((3<mes) && (mes<9)) || (mes==3 && 21<=dia) || (mes==9 && dia<=20)) {
            return InAllotjament.Temp.ALTA;
        }
        else{ return InAllotjament.Temp.BAIXA; }
    }

    /**
     * Retorna el nom del càmping.
     *
     * @return el nom del càmping.
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna la llista de reserves del camping.
     *
     * @return
     */
    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

    /**
     * Retorna la llista d'allotjaments del camping.
     */
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return listaAllotjament;
    }

    /**
     * Retorna la llista de clients del camping.
     *
     * @return
     */
    @Override
    public ArrayList<Client> getLlistaClients() {
        return listaClient;
    }

    /**
     * Retorna el número total d'allotjaments del càmping.
     *
     * @return el número total d'allotjaments.
     */
    @Override
    public int getNumAllotjaments() {
        return listaAllotjament.size();
    }

    /**
     * Retorna el número total de reserves del càmping.
     *
     * @return el número total de reserves.
     */
    @Override
    public int getNumReserves() {
        return llistaReserves.getNumReserves();
    }

    /**
     * Retorna el número total de clients del càmping.
     *
     * @return el número total de clients.
     */
    @Override
    public int getNumClients() {
        return listaClient.size();
    }

    /**
     * Crea un nou objecte de tipus Client i l'afegeix a la llista de clients.
     *
     * @param nom_ el nom del nou client.
     * @param dni_ el DNI del nou client.
     */
    @Override
    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_, dni_);
        listaClient.add(client);
    }

    /**
     * Afegeix una nova parcel·la a la llista d'allotjaments.
     *
     * @param nom_              el nom de la parcela.
     * @param idAllotjament_    l'identificador únic de l'allotjament.
     * @param metres            la mida de la parcela.
     * @param connexioElectrica true si disposa de connexió elèctrica, false altrament.
     */
    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
    Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
    listaAllotjament.add(parcela);
    }

    /**
     * Afegeix un nou bungalow a la llista d'allotjaments.
     *
     * @param nom_           el nom del bungalow.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param mida           la mida del bungalow.
     * @param habitacions    el nombre d'habitacions del bungalow.
     * @param placesPersones el nombre màxim de places per a persones.
     * @param placesParquing el nombre de places de pàrquing disponibles.
     * @param terrassa       true si disposa de terrassa, false altrament.
     * @param tv             true si disposa de televisió, false altrament.
     * @param aireFred       true si disposa d'aire condicionat, false altrament.
     */
    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        listaAllotjament.add(bungalow);
    }

    /**
     * Afegeix un bungalow premium a la llista d'allotjaments.
     *
     * @param nom_
     * @param idAllotjament_
     * @param mida
     * @param habitacions
     * @param placesPersones
     * @param placesParquing
     * @param terrassa
     * @param tv
     * @param aireFred
     * @param serveisExtra   true si ofereix serveis extra.
     * @param codiWifi       el codi de la xarxa Wi-Fi.
     *                       (Altres paràmetres igual que `afegirBungalow`)
     */
    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        listaAllotjament.add(bungalowPremium);
    }

    /**
     * Afegeix una casa glamping a la llista d'allotjaments.
     *
     * @param nom_
     * @param idAllotjament_
     * @param mida
     * @param habitacions
     * @param placesPersones
     * @param material       el material del que està fet.
     * @param casaMascota    true si accepta mascotes.
     *                       (Altres paràmetres igual que `afegirBungalow`)
     */
    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        listaAllotjament.add(glamping);
    }

    /**
     * Afegeix una mobil-home a la llista d'allotjaments.
     *
     * @param nom_
     * @param idAllotjament_
     * @param mida
     * @param habitacions
     * @param placesPersones
     * @param terrassaBarbacoa true si disposa de terrassa amb barbacoa.
     *                         (Altres paràmetres igual que `afegirBungalow`)
     */
    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones,terrassaBarbacoa);
        listaAllotjament.add(mobilHome);
    }

    /**
     * Afegeix una nova reserva al càmping. Per fer-ho fa el següent: cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i la afegirà a la llista de reserves.
     *
     * @param id_         l'identificador de l'allotjament.
     * @param dni_        el DNI del client que fa la reserva.
     * @param dataEntrada la data d'entrada.
     * @param dataSortida la data de sortida.
     * @throws ExcepcioReserva si no es pot realitzar la reserva.
     */
    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{

            Allotjament allotjamentActual = buscarAllotjament(id_);
            Client clientActual = buscarClient(dni_);
            llistaReserves.afegirReserva(allotjamentActual, clientActual, dataEntrada, dataSortida);
            System.out.println("Reserva feta amb exit!");
    }
    /**
     * Cerca un allotjament a la llista d'allotjaments del camping pel seu identificador.
     * Recorre tota la llista d'allotjaments fins a trobar aquell que coincideixi amb l'ID proporcionat.
     *
     * @param id_ L'identificador de l'allotjament que es vol buscar
     * @return L'allotjament amb l'ID especificat
     * @throws ExcepcioReserva Si no existeix cap allotjament amb l'ID proporcionat a la llista
     */

    private Allotjament buscarAllotjament(String id_) throws ExcepcioReserva{
        Iterator<Allotjament> itr = listaAllotjament.iterator();

        while(itr.hasNext()){
            Allotjament allotjamentActual = itr.next();
            if(allotjamentActual.getId().equals(id_)){
                return allotjamentActual;
            }
        }
            throw new ExcepcioReserva("L'allotjament amb id "+ id_+ " no existeix");
    }

    /**
     * Cerca un client a la llista de clients del camping pel seu DNI.
     * Recorre tota la llista de clients fins a trobar aquell que coincideixi amb el DNI proporcionat.
     *
     * @param dni_ El DNI del client que es vol buscar
     * @return El client amb el DNI especificat
     * @throws ExcepcioReserva Si no existeix cap client amb el DNI proporcionat a la llista
     */

    private Client buscarClient(String dni_) throws ExcepcioReserva{
        Iterator<Client> itr = listaClient.iterator();

        while(itr.hasNext()){
            Client clientActual = itr.next();
            if(clientActual.getDni().equals(dni_)){
                return clientActual;
            }
        }
        throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
    }


    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
     *
     * @return el nombre de serveis operatius.
     */
    @Override
    public int calculAllotjamentsOperatius() {
        int operatiusTmp = 0;
        Iterator <Allotjament> itr = listaAllotjament.iterator();
        while(itr.hasNext()){
            if (itr.next().correcteFuncionament())
            {
                operatiusTmp++;
            }
        }
        return operatiusTmp;
    }

    /**
     * Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta.
     *
     * @param temp
     * @return l'allotjament amb estada mínima de la temporada baixa més curta.
     */
    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        boolean primerCop = false;
        Allotjament allotjamentEstadaMin = null;
        long estadaCurta = 0;

        Iterator <Allotjament> itr = listaAllotjament.iterator();
        while(itr.hasNext()) {
            if(!primerCop)
            {
                allotjamentEstadaMin = itr.next();
                estadaCurta = allotjamentEstadaMin.getEstadaMinima(temp);
                primerCop = true;
            }
            else {
                Allotjament allotjamentTmp = itr.next();
                long estadaCurtaTmp = allotjamentTmp.getEstadaMinima(temp);
                if (estadaCurtaTmp < estadaCurta)
                {
                    allotjamentEstadaMin = allotjamentTmp;
                    estadaCurta = estadaCurtaTmp;
                }
            }
        }
        return allotjamentEstadaMin;
    }

    //--------------------------------------------------------PRACTICA 2 -----------------------------------------------
    /**
     * Retorna el nom del càmping.
     *
     * @return String
     */
    @Override
    public String getNomCamping() {
        return getNom();
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

    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    @Override
    public void inicialitzaDadesCamping() {

    }
}


