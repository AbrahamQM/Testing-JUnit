package ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.UsuariosBuilder;
import java.util.ArrayList;

public class UsuariosDBStub extends UsuariosDBMemoria{

    Usuario usuario = new UsuariosBuilder("usuarioStub")
            .conNombre("Stub")
            .conApellidos("Demo")
            .conEmail("demo@stub.tld")
            .conNivelDeAcceso(15)
            .build();
    @Override
    public ArrayList<Usuario> obtener() {
        ArrayList<Usuario> usuarios = new ArrayList();

        usuarios.add(usuario);
        return usuarios;
    }

}

