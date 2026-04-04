package prog2.vista;

import prog2.model.Camping;
import prog2.vista.Menu;

import java.util.Scanner;

public class VistaCamping {


    private Camping camping;


    // Declarem les opcions per a referir-se a les opcions del menú.
    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,MENU_PRINCIPAL_OPCIO3, MENU_PRINCIPAL_OPCIO4, MENU_PRINCIPAL_OPCIO5, MENU_PRINCIPAL_OPCIO6, MENU_PRINCIPAL_OPCIO7, MENU_PRINCIPAL_OPCIO8, MENU_PRINCIPAL_OPCIO9, MENU_PRINCIPAL_OPCIO10, MENU_PRINCIPAL_OPCIO11, MENU_PRINCIPAL_OPCIO12,MENU_PRINCIPAL_SORTIR};
    static private enum OpcionsSubmenu1 {MENU_S1_OPCIO1,MENU_S1_OPCIO2,MENU_S1_SORTIR};

    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal={
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació de les tasques de manteniments actives",
            "Afegir una tasca de manteniment",
            "Completar una tasca de manteniment",
            "Calcular i mostrar el número total d’accessos que NO proporcionen accessibilitat amb vehicle",
            "Calcular i mostrar el número total de metres dels accessos de terra",
            "Guardar càmping",
            "Recuperar càmping",
            "Sortir de l'aplicació"};

    // Declarem descripcions personalitzades per a les opcions del menú secundari
    static private String[] descMenu2={"Primera Opció del menú secundari",
                                        "Segona Opció del menú secundari",
                                            "Menú anterior"};


    VistaCamping(String nomCamping) {
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }


    public void gestorCamping() {

        Scanner sc=new Scanner(System.in);

        // Creem l'objecte per al menú. Li passem com a primer parà metre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);

            // Fem les accions necessÃ ries
            switch(opcio) {
                case MENU_PRINCIPAL_OPCIO1:
                    camping.llistarAllotjaments("Operatiu");
                    camping.llistarAllotjaments("No Operatiu");
                    break;

                case MENU_PRINCIPAL_OPCIO2:
                    camping.llistarAllotjaments("Operatiu");
                    break;

                case MENU_PRINCIPAL_OPCIO3:
                    camping.llistarAllotjaments("No Operatiu");
                    break;

                case MENU_PRINCIPAL_OPCIO4:
                    camping.llistarAccessos("Obert");
                    break;

                case MENU_PRINCIPAL_OPCIO5:
                    camping.llistarAccessos("Tancat");

                    break;
                case MENU_PRINCIPAL_OPCIO6:
                    camping.llistarTasquesManteniment();
                    break;

                case MENU_PRINCIPAL_OPCIO7:
                    // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                    System.out.println("Has triat la opciÃ³ 2");
                    break;

                case MENU_PRINCIPAL_OPCIO8:
                    // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                    System.out.println("Has triat la opciÃ³ 2");
                    break;

                case MENU_PRINCIPAL_OPCIO9:
                    System.out.println("Accessos que NO proporcionen accessibilitat amb vehicle: " +camping.calculaAccessosNoAccessibles());
                    break;

                case MENU_PRINCIPAL_OPCIO10:
                    System.out.println("Número total de metres dels accessos de terra" + camping.calculaMetresTerra());
                    break;

                case MENU_PRINCIPAL_OPCIO11:
                    camping.
                    break;
                case MENU_PRINCIPAL_OPCIO12:
                    // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                    System.out.println("Has triat la opciÃ³ 2");
                    break;

                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!= OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);





    }
}
