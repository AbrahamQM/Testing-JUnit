package ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;

import java.util.ArrayList;

public class UsuariosDBMemoria extends UsuariosDB {
    //Declaración de las variables necesarias para los métodos de la interfaz UsuariosDBEstadisticas
    private int totalEliminaciones =0;
    private int totalInserciones =0;
    //Fin declaración, IMPLEMENTACIÓN AL FINAL DE LA CLASE

    ArrayList<Usuario> usuarios = new ArrayList();

    @Override
    public ArrayList<Usuario> obtener() {
        return usuarios;
    }

    @Override
    public Usuario buscar(Usuario usuario){
        for (Usuario usuarioActual : obtener()) {
            if (usuarioActual.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public boolean insertar(Usuario usuario) {
        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.nombreUsuario.toLowerCase().equals(usuario.nombreUsuario.toLowerCase())) {
                return false;
            }
        }
        usuarios.add(usuario);
        totalInserciones++; //Añadida para actualizar la estadística
        return true;
    }

    @Override
    public boolean borrar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) {
                usuarios.remove(i);
                totalEliminaciones++;//Añadida para actualizar la estadística
                return true;
            }
        }
        return false;
    }

    /*IMPLEMENTACIÓN DE LOS MÉTODOS de la interfaz UsuariosDBEstadisticas*/
    //Hay que modificar los métodos para que incrementen totalInserciones y totalEliminaciones

    public int getTotalInserciones() {
        return totalInserciones;
    }

    public int getTotalEliminaciones() {
        return totalEliminaciones;
    }
}
