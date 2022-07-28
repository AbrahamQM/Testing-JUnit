package usuarios;

import java.util.ArrayList;

//Esta clase se va a encargar de almacenar los usuarios en un ArrayList
public class Usuarios {
    ArrayList<Usuario> arrayUsuarios = new ArrayList();

    //Esta función devolverá un Objeto tipo Usuario con valor el usuario que le pasemos
     public Usuario crear(Usuario usuario){
//         return null //-->1ª parte de TDD: Test Failure

//        return usuario; //-->2ª Parte, pasamos el test devolviendo lo que espera.

        arrayUsuarios.add(usuario); //-->3º Hacemos que la función almacene el usuario tal como debe

        return usuario;//-->4º Devolvemos el usuario almacenado
    }

    public String buscar(Usuario usuario) {
//         return ""; //-->1º Test failure
        /******* Implementado por mi:
         *
        if (arrayUsuarios.contains(usuario)){
            return usuario.nombre;
        }
        return "";
         *
        *******/

        //Implementado por el profe:
        for(Usuario usuarioActual : arrayUsuarios){
            if (usuarioActual.nombre.equalsIgnoreCase(usuario.nombre)){
                return usuarioActual.nombre;
            }
        }
        return "";
    }

    public boolean borrar(Usuario usuario) {
         /**  Implementada por mi:
         for(Usuario usuarioActual : arrayUsuarios){
             if (usuarioActual.nombre.equalsIgnoreCase(usuario.nombre)){
                 arrayUsuarios.remove(usuarioActual);
                 return true;
             }
         }
         return false;
          **/

         //Implementada por el profe:
        return arrayUsuarios.remove(usuario); //La función remove devuelve true si lo ha encontrado y borrado.
        //devuelve false en caso de no encontrar el objeto indicado.

    }
}
