package ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities;
//A las entidades habitualmente se les llama POJO:
//                                           Plain-Old-Java-Object
public class Usuario {
    public String nombreUsuario;
    public String nombre;
    public String apellidos;
    public String email = "";
    public int nivelAcceso;

    @Override
    public String toString() {
        return "nombre de usuario: " + nombreUsuario + "\r\n"
                + "nombre: " + nombre + "\r\n"
                + "apellidos: " + apellidos + "\r\n"
                + "email: " + email + "\r\n"
                + "nivel de acceso: " + nivelAcceso;
    }
}
