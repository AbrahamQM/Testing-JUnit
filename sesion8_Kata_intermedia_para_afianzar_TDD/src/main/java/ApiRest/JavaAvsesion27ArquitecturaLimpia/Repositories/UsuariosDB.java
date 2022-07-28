package ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories;
/**Esta es la clase donde haremos las principales modificaciones*/
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;

import java.util.ArrayList;

 abstract public class UsuariosDB {

    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    protected void incrementarInserciones() {totalInserciones ++;}
    protected void incrementarEliminaciones() {totalEliminaciones ++;}

    abstract public ArrayList<Usuario> obtener();
     abstract public Usuario buscar(Usuario usuario);
     abstract public boolean insertar(Usuario usuario);
     abstract public boolean borrar(Usuario usuario);
}
