package usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuariosTest {

    /** *********************************************************************************************************
     *          última parte de la medología TDD ---REFACTORIZACIÓN---
     *
     * All lo que cambiemos estará comentado igual que este texto
     * para que se vea en verde y poder ver el proceso.
     */
    Usuarios usuarios = new Usuarios();
    Usuario usuario = new Usuario();
    private final String nombrePorDefecto = "pruebas"; //Por si queremos cambiar el valor,
    // se cambiará en todas las concurrencias a la vez

    @BeforeEach
    void inicializa(){ //Inicializar los valores de un objeto se debe hacer con una función, no se puede poner fuera
        usuario.nombre = nombrePorDefecto;
    }


    /************************** Fin de extraer objetos y variables utilizados múltiples veces ****************/



    //******** TEST 1 comprueba que se crea un Usuario y se almacena el Usuario en la clase Usuarios
    //Primero creamos el test antes de desarrollar el código.
    @Test
    void pruebaCrearUsuario(){
        /**
        //Instanciamos la clase Usuarios
        Usuarios usuarios = new Usuarios();

        //Instanciamos un usuario del tipo Usuario y le asignamos un nombre
        Usuario usuario= new Usuario();

        usuario.nombre = "pruebas";
        **/

        //Creamos otro usuario del tipo Usuario usando el método crear de la clase usuarios
        Usuario usuarioCreado = usuarios.crear(usuario);

        //Comprobamos:
        //El usuarioCreado tiene el nombre "pruebas"
        /**assertEquals(usuarioCreado.nombre, "pruebas");**/
        assertEquals(usuarioCreado.nombre, nombrePorDefecto);
    }

    //******* TEST 2 Probamos que se puede obtener el usuario almacenado en la clase Usuarios
    @Test
    void pruebaObtenerUsuario(){
        /**
        Usuarios usuarios = new Usuarios();

        Usuario usuario = new Usuario();

        usuario.nombre = "pruebas";
        **/

        usuarios.crear(usuario); //Almacenamos el usuario en la clase Usuarios
        // (ignorando lo que nos devuelva, xq ya lo hemos comprobado en el test anterior.)

        String resultado = usuarios.buscar(usuario); //Función que debe devolver un String con el nombre del usuario ...
        // en caso de encontrarlo o, "" en caso de no hacerlo.
        /**assertEquals("pruebas", resultado);**/
        assertEquals(nombrePorDefecto, resultado);
    }


    //******** Test 3 Probamos que podemos Borrar usuario
    @Test
    void pruebaBorrarUsuario(){
        /**
        Usuarios usuarios = new Usuarios();

        Usuario usuario = new Usuario();

        usuario.nombre = "pruebas";
        **/

        usuarios.crear(usuario); //Almacenamos el usuario en la clase Usuarios
        // (ignorando lo que nos devuelva, xq ya lo hemos comprobado en el 1º test.)

        assertEquals(true, usuarios.borrar(usuario)); //Devuelve true la primera vez porque lo hemos creado
//        assertEquals(true, usuarios.borrar(usuario)); //devuelve false porque ya se ha borrado antes
    }


    //----------------------Después de que se cumplan todos los test,
    //----------------------hemos hecho un "coverage test" que mostraba que algunas de las líneas no se ejecutaban
    //----------------------Por eso vamos a implementar otro test que garantiza que se ejecutan las línes que faltaban
    @Test
    void pruebaObtenerUsuarioNoExistente(){
        usuario.nombre = "usuario Inexistente"; //Modificamos el nombre al usuario que después no podrá encontrar
        assertEquals("", usuarios.buscar(usuario)); //Indicamos que esperamos que devuelva "" al no encontrarlo
    }
}
