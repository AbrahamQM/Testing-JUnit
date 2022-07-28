package curso;

//Clase creada para obtener las propiedades de sistema para test verificaSuma4
public class Main {
    public static void main(String[] args) {
       //Obtenemos las propiedades de sistema y sus valores, para configurar el test verificaSuma4()
      for (String actual : System.getProperties().stringPropertyNames()){
        System.out.println(actual + ": " + System.getProperty(actual));
      }
        System.out.println("Arqutectura del Sistema operativo: " + System.getProperty("os.arch"));
    }
}
