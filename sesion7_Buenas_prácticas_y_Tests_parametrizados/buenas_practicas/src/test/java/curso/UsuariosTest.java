package curso;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class UsuariosTest {
    //********************************************************************************************//
    //                                      TESTs ANIDADOS
    //Primero comprobamos que se crea un usuario y después probamos a probarlo. (de forma anidada)

    //Instancio la clase Usuarios fuera para que ambos tests puedan trabajar sobre la misma BD de usuarios
    Usuarios usuarios = new Usuarios();
    Usuario usuario = new Usuario();

    //1º Testeamos que se crea
    @Test
    void crear() {
        usuario.nombre = "Pepe";
        assertEquals(true, usuarios.crear(usuario));
    }


//    Creamos otra clase para anidarla con la notación @Nested (anidado)
    @Nested
    @EnabledIf("curso.UsuariosCondition#puedeCrearseUsuario") //Le indicamos que se ejecute si se cumple la condición
    public class SoloSiUsuariosHaSidoCreado{
        @BeforeEach
        void  inicializar() {
            usuario.nombre = "Pepe";
            usuarios.crear(usuario);
        }

        @Test
        void borrar(){
            assertEquals(true, usuarios.borrar(usuario));
        }

        @Test
        @DisplayName("¿Tengo usuarios?")
        void listar(){
            ArrayList<Usuario> listado = usuarios.obtener();
            System.out.println("Num de usuarios creados: " + listado.size());
            assertNotEquals(listado.size() == 0, listado);
        }

        @Nested
        public class ListarSoloSiSeHaBorrado{
            @Test
            void listarBorrados(){
                ArrayList<Usuario> listado = usuarios.obtener();
                assertEquals(listado.size() == 0, listado);
            }
        }
    }
    //********************************************************************************************//
    //                              TESTS PARAMETRIZADOS

    //EN LUGAR DE @TEST USAREMOS @ParameterizedTest
    @ParameterizedTest
    @ValueSource( strings = {"Pepe", "Juan", "Manolo"}) //le indicamos que son strings y le pasamos una lista de valores
    void crearParametrizado(String nombre){
        usuario.nombre = nombre;
        assertEquals(true, usuarios.crear(usuario));

        for (Usuario usuarioActual : usuarios.obtener()){
            System.out.println("--Usuario: " + usuarioActual.nombre);
        }
    }
}
