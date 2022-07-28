package FakeData;

import java.util.ArrayList;

//Esta clase simularía datos de una bbdd y, nos daría los datos que esperamos para nuestro programa.
public class DatosFalsos {
    public DatosFalsos(){
        System.out.println("Datos conectados, en producción!!");
    }

    public ArrayList<String> getData(){
        ArrayList<String> retorno = new ArrayList();
        retorno.add("Hola");
        retorno.add("Mundo");
        return retorno;
    }
}
