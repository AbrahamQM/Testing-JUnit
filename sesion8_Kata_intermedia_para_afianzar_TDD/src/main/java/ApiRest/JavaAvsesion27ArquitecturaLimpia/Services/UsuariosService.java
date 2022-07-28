package ApiRest.JavaAvsesion27ArquitecturaLimpia.Services;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDB;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories.UsuariosDBMemoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service //Le indicamos que esto es un servicio
public class UsuariosService {
    public UsuariosDB usuariosDB = new UsuariosDBMemoria();

    public void Usuarios(UsuariosDB usuariosDB) {
        this.usuariosDB = usuariosDB;
    }

    private void Usuarios() {}

    public ArrayList<Usuario> listarUsuarios() {
        return usuariosDB.obtener();
    }

    public Usuario obtenerUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        return usuariosDB.buscar(usuario);
    }

    public void crearUsuario(Usuario usuario) {
        if (usuariosDB.buscar(usuario) != null) {
            return;
        }

        usuariosDB.insertar(usuario);
    }

    public void borrarUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        usuariosDB.borrar(usuario);
    }
}
