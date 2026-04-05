package prog2.vista;

import prog2.model.Camping;
import prog2.vista.Menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaCamping {


    private Camping camping;


    // Declarem les opcions per a referir-se a les opcions del menú.
    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,MENU_PRINCIPAL_OPCIO3, MENU_PRINCIPAL_OPCIO4, MENU_PRINCIPAL_OPCIO5, MENU_PRINCIPAL_OPCIO6, MENU_PRINCIPAL_OPCIO7, MENU_PRINCIPAL_OPCIO8, MENU_PRINCIPAL_OPCIO9, MENU_PRINCIPAL_OPCIO10, MENU_PRINCIPAL_OPCIO11, MENU_PRINCIPAL_OPCIO12,MENU_PRINCIPAL_SORTIR};

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
                   try {
                       System.out.println(camping.llistarAllotjaments("Operatiu"));
                       System.out.println(camping.llistarAllotjaments("No Operatiu"));

                   } catch (ExcepcioCamping e) {
                       System.out.println(e.getMessage());
                   }
                    break;

                case MENU_PRINCIPAL_OPCIO2:
                   try {
                       System.out.println(camping.llistarAllotjaments("Operatiu"));
                   } catch (ExcepcioCamping e) {
                       System.out.println(e.getMessage());
                   }
                    break;

                case MENU_PRINCIPAL_OPCIO3:
                    try {
                        System.out.println(camping.llistarAllotjaments("No Operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO4:
                    try {
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO5:
                    try {
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO6:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO7:
                    try{
                        int num;
                        String tipus;
                        String idAllotjament;
                        String data;
                        int dies;

                        System.out.println("Numero de tasca: ");
                        num = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Tipus de tasca: ");
                        tipus = sc.nextLine();
                        System.out.println("Id del Allotjament: ");
                        idAllotjament = sc.nextLine();
                        System.out.println("Data: ");
                        data = sc.nextLine();
                        System.out.println("Numero de dies: ");
                        dies = sc.nextInt();

                        camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);
                    }
                    catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }
                    break;


                case MENU_PRINCIPAL_OPCIO8:
                    try {
                        camping.llistarTasquesManteniment();
                        System.out.println("Quina numero de tasca vols completar: ");
                        camping.completarTascaManteniment(sc.nextInt());

                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO9:
                    try {
                        System.out.println("Accessos que NO proporcionen accessibilitat amb vehicle: " + camping.calculaAccessosNoAccessibles());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO10:
                        System.out.println("Número total de metres dels accessos de terra: " + camping.calculaMetresTerra());
                    break;

                case MENU_PRINCIPAL_OPCIO11:
                    try {
                        System.out.println("Nombre del fitxer per guardar: ");
                        camping.save(sc.nextLine());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO12:
                    try {
                        System.out.println("Nombre del fitxer per carregar: ");
                        camping = camping.load(sc.nextLine());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!= OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);





    }
}
