package ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;



class UsuariosDBFicheroTest {
    UsuariosDB usuariosDB = new UsuariosDBFichero();


    @BeforeAll //este test es sólo para subir la cobertura, una vez creado el fichero ya no se ejecuta más la función
    public static void crearFichero(){
        UsuariosDBFichero usuariosDB = new UsuariosDBFichero();
        usuariosDB.crearFichero();
    }

    @Test
    void obtenerSinFichero() {
        ArrayList<Usuario> usuarios = usuariosDB.obtener();

        assertNotEquals(null, usuarios); //Comprobamos que no devuelve un null
    }

    @Nested
    public class conFicheroCreado{
//        @BeforeAll //Obligamos a crear el fichero (lo hice de forma manual, pero el test no podía acceder a el)
//        static void init(){
//            UsuariosDBFichero usuariosDB = new UsuariosDBFichero();
//            usuariosDB.crearFichero();
//        }

        @Test
        void crearUsuario(){
            Usuario usuario = new Usuario();
            usuario.nombreUsuario = "open";
            usuario.nombre = "Open";
            usuario.apellidos = "Borbon";
            usuario.email = "rey@casareal.com";
            usuario.nivelAcceso = 5;



            usuariosDB.buscar(usuario); //Por si existe el usuario, no se ejecutará el resto del test

            boolean resultado = usuariosDB.insertar(usuario);

            assertNotEquals(false, resultado);
        }

        @Nested
        @TestMethodOrder(OrderAnnotation.class) //Al profe se le ejecutan en orden, pero a mi no así que tengo
        // que obligarlos a ejecutarse en un orden. Ver @Order(9
        public class conUsuarioCreado{
            @BeforeAll  //LOS BEFOREALL DEBEN SER CLASES ESTÁTICAS O FALLARÁ EL CÓDIGO
            public static void inicializar(){
                Usuario usuario = new Usuario();
                usuario.nombreUsuario = "open";
                usuario.nombre = "Open";
                usuario.apellidos = "Borbon";
                usuario.email = "rey@casareal.com";
                usuario.nivelAcceso = 5;

                UsuariosDB usuariosDB = new UsuariosDBFichero();
                usuariosDB.insertar(usuario);//no hace falta una assert porque ya lo probamos en crearUsuario()
            }

            @Test
            @Order(1)
            void obtenerConFichero() {
                ArrayList<Usuario> usuarios = usuariosDB.obtener();
                assertNotEquals(null, usuarios); //Comprobamos que no devuelve un null
            }

            @Test
            @Order(2)
            void buscar() {
                Usuario usuario = new Usuario();
                usuario.nombreUsuario = "open";

                Usuario resultado = usuariosDB.buscar(usuario);
                assertNotEquals(null , resultado);
            }

            @Test
            @Order(3)
            void borrar(){

                Usuario usuario = new Usuario();
                usuario.nombreUsuario = "open";

                assumeFalse(usuariosDB.buscar(usuario) == null);

                boolean resultado = usuariosDB.borrar(usuario);
                assertNotEquals(false, resultado);
            }
        }
    }
}