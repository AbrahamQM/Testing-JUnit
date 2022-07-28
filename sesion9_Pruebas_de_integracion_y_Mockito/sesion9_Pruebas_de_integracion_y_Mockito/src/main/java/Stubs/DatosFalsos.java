package Stubs;

import java.util.ArrayList;

//Aquí implementaríamos el stub. Que sería una función que va a sustituir a otra función devolviéndonos
//los datos que nosotros queramos
public class DatosFalsos extends DatosReales{

    //este método Stub sustituye a un método de la clase real, para devolvernos unos datos que nos interesen
    //para los tests. De manera que podamos verificar que el código funciona como debe
    @Override
    public ArrayList<Double> getData(){
        ArrayList<Double> retorno = new ArrayList();
        retorno.add(1.0);
        retorno.add(2.0);
        retorno.add(3.0);

        return retorno;
    }


}
