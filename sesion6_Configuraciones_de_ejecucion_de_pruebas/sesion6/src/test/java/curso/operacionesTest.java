package curso;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


public class operacionesTest {
    //-----------------Notaciones para Activar/desactivar Test en determinados sistemas operativos-----------------
    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    // Notación que habilita el test para los sistemas que le indiquemos.
//    @DisabledOnOs(OS.LINUX)    //Notación que deshabilita el test para los sistemas que le indiquemos.
    void verificaSuma() {
        System.out.println("Estoy en un Test para Windows y MacOS");
        //Código del test
    }

    //-----------------Notaciones para ejecutarse en diferentes versiones de JVM-----------------------------------
    @Test
    @EnabledOnJre({JRE.JAVA_17, JRE.JAVA_18})
    // Notación que habilita el test para las versiones jvm que le indiquemos.
//    @DisabledOnJRE(versiones que no queremos probar) //Igual pero deshabilita el test para la jvm que indiquemos
    void verificaSuma2() {
        System.out.println("Estoy testeando con versiones JVM 17 y 18");
        //Código del test
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_10, max = JRE.JAVA_14) // No se ejecutará porque estamos con Java 18
        // Notación que habilita el test para el rango de
        // versiones jvm que le indiquemos.
//    @DisabledForJreRange() // Deshabilita  este Test para un rango de JVM
    void verificaSuma3() {
        System.out.println("verificaSuma3-->Estoy testeando con rango de versiones JVM 10 a 14");
        //Código del test
    }

//-------------Notaciones para Activar/desactivar Test en determinados System properties---------------------
    //Obtenemos la lista de propiedades de sistema con:
//    for (String actual : System.getProperties().stringPropertyNames(){
//      System.out.println(actual);
//    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = "amd64") // En este ejemplo comprobamos que la
    //propiedad de sistema os.arch (arquitectura) = amd64
    void verificaSuma4(){
        System.out.println("verificaSuma4-->Estoy testeando con propiedad de sistema os.arch = amd64");
        //Código del test
    }

    //Lo mismo pero con varias propiedades
//    @EnabledIfSystemProperties({})


//--------------Notaciones para Activar/desactivar Test según variables de entorno ---------------------------
    //Para obtener las variables de entorno, podemos ejecutar en el terminal "set"
    //Vamos a probarlo con la variable de entorno: USERNAME=Abraham

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Abraham")
    void verificaSuma5(){
        System.out.println("verificaSuma5-->Estoy testeando con la VARIABLE DE ENTORNO USERNAME = Abraham");
        //Código del test
    }

//    @EnabledIfEnvironmentVariables() // Es lo mismo, pero con una lista de variables y valores
//    @DisabledIfEnvironmentVariable() // Desactiva con una variable que le indiquemos
//    @DisabledIfEnvironmentVariables() // Lo mismo pero en plural


//--------------Notaciones para Activar/Desactivar según una condición que le indiquemos -----------------------
    @Test
    @EnabledIf("curso.operacionesCondicion#mustBeRun") //Ruta a la clase de las condiciones # método que devuelve booleano
    void verificaSuma6(){
        System.out.println("verificaSuma6-->Estoy testeando con LA CONDICIÓN declarada en operacionesCondicion");
        //Código del test
    }

    //Lo mismo pero cuando una condición devuelve false
    @Test
    @DisabledIf("curso.operacionesCondicion#mustBeRun") //No se ejecutará porque está deshabilitado si devuelve true
    void verificaSuma7(){
        System.out.println("verificaSuma7-->Estoy testeando con LA CONDICIÓN declarada en operacionesCondicion");
        //Código del test
    }


//------------- Etiquetas -------------------------------------------------------------------------------

//Vamos a crear otros 2 test para comprobar las etiquetas y crearemos una suit de test ver clase AllTests
//Luego configuramos la "suite" para que sólo ejecute los test con etiqueta "Produccion"
    @Test
    @Tag("Produccion") // También está la opción de @Tags(etiqueta1, etiqueta2, ...)
    void verificaResta1(){
        System.out.println("verificaResta1-->Estoy en verificaResta1()");
        //Código del test
    }

    @Test
    @Tag("Desarrollo")
    void verificaResta2(){
        System.out.println("verificaResta2-->Estoy en verificaResta2()");
        //Código del test
    }
//Después de declarar estos tests, vamos a la suite de tests AllTests y la ejecutamos para comprobar como solo
//    se ejecuta verificaResta1() ya que coincide con la condición de etiqueta que le hemos indicado en AllTests



//-------------- Configuración de los test en el pom ------------------------------------------------------
//Dentro del plugin que mueva el test "runner", se puede configurar el uso de unos test u otros según sus etiquetas
//Colocando dentro de <configuracion></configuracion>
// <groups> etiquetas que queramos incluir </groups> ---- seleccionamos las etiquetas de tests a ejecutar
// <excludeGroups> etiquetas que queramos excluir </excludeGroups> ------ seleccionamos las que queramos excluir
//MEJOR VER EN EL VÍDEO O BUSCAR DOCUMENTACIÓN

//--------------Modificar el orden de los test con la anotación @Order(nº de orden)------------------------
// @Order(1)
// @Order(4)
// @Order(2)
// @Order(3)
}
