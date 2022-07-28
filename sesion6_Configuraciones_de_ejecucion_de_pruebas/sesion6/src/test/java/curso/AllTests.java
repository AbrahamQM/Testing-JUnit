package curso;

// Suit de tests, creada para PROBAR LAS TAGS con los test verificaResta1 y verificaResta2

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class) //Esto es la forma antigua de usar la actual anotación @Suite
//para poder usarla, antes debemos tener la dependencia org.junit.platform en el pom.xml
@SelectPackages("curso") // Le indicamos los paquetes que queremos seleccionar
@IncludeTags("Produccion") // Hace que solo los test con la etiqueta "Produccion" se ejecute, en este caso
// solo se ejecutara el verificaResta1(). El verificaResta2 no se ejecutará porque tiene la etiqueta "Desarrollo"
public class AllTests {
    //Si ejecutamos este runner de test, sólo se ejecutará el verificaResta1()
}
