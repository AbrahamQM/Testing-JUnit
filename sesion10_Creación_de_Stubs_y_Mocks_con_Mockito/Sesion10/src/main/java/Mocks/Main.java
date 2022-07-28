package Mocks;

public class Main {
    public static void main(String[] args) {

//------------------------------- Así se haría sin un mock---------------------------------------
        Bebida bebida = new Combinado();
        Bar bar = new Bar(bebida);

        System.out.println("Ingredientes totales: " + bar.contarIngredientes());

//------------Cómo se haría con un Mock (suponemos el objeto bebida lo proporciona un tercero)-------
    //Ver el test Mocks.BarTest

    }
}
