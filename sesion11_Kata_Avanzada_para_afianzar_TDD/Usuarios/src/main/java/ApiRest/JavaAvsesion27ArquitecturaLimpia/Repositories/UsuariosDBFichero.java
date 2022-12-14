package ApiRest.JavaAvsesion27ArquitecturaLimpia.Repositories;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Stadistics.UsuariosDBEstadisticas;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosDBFichero extends UsuariosDB{
    //Variable donde asignamos el nombre del fichero con el que vamos a trabajar
    public String ficheroDatos = "fichero.txt";

    public void crearFichero(){ //COMENTADA PORQUE DESPUÉS DE CREARSE UNA VEZ, YA NO LA NECESITAMOS
        try{
            FileOutputStream file = new FileOutputStream(ficheroDatos, true);
            PrintStream print = new PrintStream(file);
            print.println("");
            print.flush();
            print.close();
        }catch (Exception e){
        }
    }
    @Override
    public ArrayList<Usuario> obtener() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String usuarioActual = scanner.next();
                String []partes = usuarioActual.split(",");

                Usuario usuarioTemp = new Usuario();
                usuarioTemp.nombreUsuario = partes[0];
                usuarioTemp.nombre = partes[1];
                usuarioTemp.apellidos = partes[2];
                usuarioTemp.email = partes[3];
                usuarioTemp.nivelAcceso = Integer.parseInt(partes[4]);

                usuarios.add(usuarioTemp);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("No puedo abrir el fichero.txt: " + e);
        }

        return usuarios;
    }

    //Lee un fichero de texto con:
    //nombreUsuario, nombre, apellidos, email, nivelAcceso
    @Override
    public Usuario buscar(Usuario usuario){
         for (Usuario usuarioActual : obtener()){
            if (usuarioActual.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)){
                return usuarioActual;
            }
        }
        return null;
    }

    @Override
    public boolean insertar(Usuario usuario){
        if ( buscar(usuario) != null ) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream prinStream = new PrintStream(fileOutputStream);
            prinStream.println(separarUsuarioPorComas(usuario));
            prinStream.flush();
            prinStream.close();

            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private String separarUsuarioPorComas(Usuario usuario) {
        return usuario.nombreUsuario + ","
                + usuario.nombre + ","
                + usuario.apellidos + ","
                + usuario.email + ","
                + usuario.nivelAcceso;
    }

    @Override
    public boolean borrar(Usuario usuario) {
        boolean status = false;
        ArrayList<Usuario> usuarios = obtener();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) {
                usuarios.remove(i);

                try {
                    PrintStream printStream = new PrintStream(ficheroDatos);

                    for (Usuario usuarioActual : usuarios) {
                        String usuarioComas = separarUsuarioPorComas(usuarioActual);
                        printStream.println(usuarioComas);
                    }

                    printStream.close();
                    status = true;

                } catch (Exception e) {
                }
            }
        }
        return status;
    }
}
