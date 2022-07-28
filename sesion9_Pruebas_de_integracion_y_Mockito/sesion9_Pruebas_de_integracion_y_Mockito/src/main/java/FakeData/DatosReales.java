package FakeData;

import java.util.ArrayList;

//Aquí esperaríamos que el constructor por ejemplo, confirmara que nos hemos conectado a una BBDD real.
public class DatosReales {
    public DatosReales(){
        System.out.println("Datos conectados, en producción!!");
    }

    public ArrayList<Double> getData(){
        //Conexión a BBDD real
        //Retornamos los datos que se soliciten.

    }
}
