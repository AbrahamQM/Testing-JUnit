package curso;

public class UsuariosCondition {
    static boolean puedeCrearseUsuario(){
        Usuarios usuarios = new Usuarios();
        return usuarios.crear(new Usuario());
    }
}
