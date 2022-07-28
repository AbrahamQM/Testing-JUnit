package ApiRest.JavaAvsesion27ArquitecturaLimpia.Services;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.UsuariosBuilder;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDB;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDBFichero;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDBMemoria;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDBStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UsuariosServiceTest {
    UsuariosService usuariosService = new UsuariosService();
    UsuariosDB usuariosDB = mock(UsuariosDBFichero.class);//Creamos el mock
    //Para cuando queramos hacer pruebas reales--ver antesDe()
    UsuariosDB usuariosDBReal = new UsuariosDBFichero();
    Usuario usuario = new UsuariosBuilder("UsuarioMock").build();

    @BeforeEach
    void antesDe(){
        usuariosService.setUsuariosDB(usuariosDB); //Con BBDD mockeada
//        usuariosService.setUsuariosDB(usuariosDBReal);  //Con bbdd en fichero.txt
    }

//                  STUB
    //Test obtenerUsuario Usando el stub UsuariosDBStub
    @Test
    void obtenerUsuario() {
        UsuariosDB usuariosDBStub = new UsuariosDBStub();
        usuariosService.setUsuariosDB(usuariosDBStub);//Aquí Setteamos el UsuariosDB para que use nuestra clase UsuariosDBStub

        Usuario resultado = usuariosService.obtenerUsuario("usuarioStub");
        assertEquals(resultado.nombreUsuario, "usuarioStub");
    }

//                  MOCKs
    //Test obtenerUsuario Usando un mock
    @Test
    void obtenerUsuarioMock() {
        when(usuariosDB.buscar(usuario))//Mockeamos la clase usuariosDB para que nos
                .thenReturn(usuario);// devuelva el usuario que hemos creado al principio de la clase.

         assertEquals(usuario.nombreUsuario, "UsuarioMock");
    }

    @Test
    void crearUsuarioMock(){
        when(usuariosDB.buscar(usuario))
                .thenReturn(usuario);
        when(usuariosDB.insertar(usuario))
                .thenReturn(true);

        boolean resultado = usuariosService.crearUsuario(usuario);
        assertTrue(resultado);
    }


    @Test
    void crearUsuarioQueNoExisteMock(){
        when(usuariosDB.buscar(usuario))
                .thenReturn(null);

        boolean resultado = usuariosService.crearUsuario(usuario);
        assertTrue(resultado);
    }

    @Test
    void borrarUsuarioMock(){
        boolean resultado = usuariosService.borrarUsuario(usuario.nombreUsuario);
        assertTrue(resultado);
    }
}