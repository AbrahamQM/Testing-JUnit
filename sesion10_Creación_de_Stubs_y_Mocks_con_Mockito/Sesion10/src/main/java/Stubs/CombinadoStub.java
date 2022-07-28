package Stubs;

public class CombinadoStub extends Combinado{

    //creamos un Stub para nuestro test de contarIngredientes
    @Override
    public int contarIngredientes(){
        System.out.println("Probando ingredientes desde el Stub");
        System.out.println("Valor real: " + super.contarIngredientes()); //Aquí mostramos el valor real del método padre
        return 3;
    }
}
