package Mocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BarTest {
//Ojo para usar el mockito ver las dependencias en el pom
    @Test
    void contarIngredientes(){
//        Bebida bebida = new Combinado(); //Sin mock


        Bebida bebida = mock(Combinado.class); //con mockito --Podemos usar la clase Cerveza o combinado indistintamente
//        Bebida bebida = mock(Cerveza.class); //con mockito --Podemos usar la clase Cerveza o combinado indistintamente

        when(bebida.contarIngredientes())
                .thenReturn(5); // Aquí le decimos a mockito cuantos ingredientes debe tener la bebida MOCKEAMOS
//                .thenCallRealMethod(); // Llama al método real sin sustituir el valor (Lo pongo sólo como muestra)

        Bar bar = new Bar(bebida);

        assertEquals(5, bar.contarIngredientes());
    }
}