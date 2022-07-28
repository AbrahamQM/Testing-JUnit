package ApiRest.JavaAvsesion27ArquitecturaLimpia.Services;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.UsuariosBuilder;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoExtendUsuariosServiceTest {
    @Mock
    UsuariosDB usuariosDB;

    @InjectMocks
    UsuariosService usuariosService;// = new UsuariosService();

    Usuario usuario = new UsuariosBuilder("usuarioStub").build();

    @Test
    void crearUsuario() {
        when(usuariosDB.insertar(usuario))
                .thenReturn(true);

        boolean resultado = usuariosService.crearUsuario(usuario);
        assertTrue(resultado);
    }
}