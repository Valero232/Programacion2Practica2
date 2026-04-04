package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {


    private Camping camping;

    VistaCamping(String nomCamping){
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }



    // menu, acabar al final
    public void gestorCamping(){}
}
