package Stubs;

import Stubs.Combinado;
import Stubs.CombinadoStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinadoTest {

    @Test //Test normal que fallará casi seguro, ya que no sabemos los valores que hay.
    void contarIngredientes(){
        Combinado combinado = new Combinado();
        int resultado = combinado.contarIngredientes();
        assertEquals(resultado, 3);
    }

//----------------------------Stub----------------------------------------
    @Test //Test usando el stub
    void contarIngredientesStub(){
        CombinadoStub combinado = new CombinadoStub();
        int resultado = combinado.contarIngredientes();
        assertEquals(resultado, 3);
    }



}