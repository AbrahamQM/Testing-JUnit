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

    //**JUnit sesión 11****JUnit sesión 11****JUnit sesión 11****JUnit sesión 11****JUnit sesión 11**
    public void setUsuariosDB(UsuariosDB usuariosDB){
        this.usuariosDB = usuariosDB;
    }
    //FIN**JUnit sesión 11****JUnit sesión 11****JUnit sesión 11****JUnit sesión 11**

    public Usuario obtenerUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        return usuariosDB.buscar(usuario);
    }

    public boolean crearUsuario(Usuario usuario) {
        if (usuariosDB.buscar(usuario) != null) {
            return false;
        }

        return usuariosDB.insertar(usuario);

    }

    public boolean borrarUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        usuariosDB.borrar(usuario);
        return true;
    }
}
