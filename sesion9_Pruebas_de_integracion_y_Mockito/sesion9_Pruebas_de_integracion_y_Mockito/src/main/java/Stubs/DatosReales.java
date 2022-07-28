package Stubs;

import java.util.ArrayList;

//Aquí estaría la función real que nos devuelve datos reales.

//El stub (Implementado como ejemplo en DatosFalsos)
public class DatosReales {

    public ArrayList<Double> getData(){
        ArrayList<Double> retorno = new ArrayList();
        for (int i = 0; i < 3; i++ ) {
            double valor = Math.random() * 100;
            retorno.add(valor);
        }

        return retorno;
    }
}
