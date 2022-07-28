package operaciones;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AritmeticaTest {

    @BeforeAll //Antes de que se ejecute cualquiera de los test
    static void init(){
        System.out.println("\n---->Antes de los Tests<----");
    }


    @BeforeEach // Antes de cada test
    void before(){
        System.out.println("-->Antes del test actual<--");
    }


    @AfterEach // Después de cada test
    void afterEach(){
        System.out.println("-->Después del test actual<--");
    }


    @AfterAll //Después de ejecutarse todos los test
    static void after(){
        System.out.println("---->Todos los Test finalizados<----");
    }


    @Test
    @DisplayName("Pruebo 4 + 4") //Por si le queremos dar otro nombre diferente al de la función
    void probar4mas4(){
        System.out.println("---->Es el test probar4mas4()");
        Aritmetica aritmetica = new Aritmetica();

        //  *************Comprobamos si el resultado es el esperado********************
        //------OJO assertEquals(valor esperado, valor obtenido, Mensaje opcional se muestra si hay error) --------
        double resultado = aritmetica.suma(4,4);
        System.out.println("\n----Comienzo assertEquals----");
        assertEquals(8, resultado, "Error en assertEquals de probar4mas4");
        System.out.println("----Fin assertEquals----");

        //  *************Comprobamos varios resultados ********************
        double resultado2 = aritmetica.suma(8,8);
        //assertAll( cabecera, lambdas con los assertEquals que queramos);
        assertAll(
                "sumadores",
                () -> System.out.println("\n----Comienzo assertAll----"),
                () -> assertEquals(8, resultado),
                () -> assertEquals(16, resultado2),
                () -> System.out.println("----Fin assertAll----")
        );

        //Test de tipo assertTrue(condición) devuelve ok si la condición da true
        System.out.println("\n-----------------test assertTrue-----------------");
        System.out.println("assertTrue( 5 > 4);");
        assertTrue( 5 > 4);
        System.out.println("-------------fin test assertTrue-----------------\n");

    }

    // ************ Hacer que un test se repita varias veces con @RepeatedTest()***************
    //@RepeatedTest(value = NUMERO_DE_REPETICIONES, name = "repetition nº: {currentRepetition} of iterations: {totalRepetitions}")
    @RepeatedTest(value = 5, name = "test: {displayName}--Repetición nº: {currentRepetition} de {totalRepetitions} iteraciones: ")
    void probar2mas2(){
        System.out.println("---->Es el test probar2mas2()");
        Aritmetica aritmetica = new Aritmetica();
        aritmetica.suma(2,2);
    }
/*
*Para ejecutar los test desde la terminal ejecutar: "mvn test"
* "mvn -Dtest=AritmeticaTest test"
* "mvn -Dtest=AritmeticaTest#probar4mas4 test" probará sólo el test probar4mas4()
*/


    // **************  TEST PARAMETRIZADOS ************************
    @ParameterizedTest
    @ValueSource(doubles = {5, 8} ) //Aquí le indicamos los parámetros con los que hará la prueba
    void probar5y8menos2(double a){
        System.out.println("---->Es el test parametrizado probar5y8menos2()");
        Aritmetica aritmetica = new Aritmetica();

        double resultado = aritmetica.resta(a,2);
        //Primero hará la prueba con los parámetros (5, 2) que es 3 y lo pasará
        //Después comprobará (8, 2), que es 6 y no lo pasará
        assertEquals(3, resultado);  //1º dará ok, 2º dará fallo
    }


    // ********************* Capturar una excepción **************************
    @Test
    void probarExcepción(){
        Aritmetica aritmetica = new Aritmetica();

        // Creamos un objeto de tipo Lanzable o Throwable (Opcional para guardar el error si queremos)
        // Usamos assertThrows(tipo de error que esperamos que lance, lambda función sobre la que queremos comprobarlo)
        Throwable excepcion = assertThrows(IOException.class, () -> aritmetica.funcionQueLanzaUnError());
    }


    // ********************Assumptions o suposiciones ***************************
    //assumeTrue: Si se cumple la suposición, se ejecutará el test
    //assumeFalse: Si no se cumple, se ejecutará el test
    @Test
    void probarAssumptionsDeExcepcion(){
        Aritmetica aritmetica = new Aritmetica();

        //Si se cumple la suposición se ejecutará el siguiente código
        assumeTrue(1 > 2); // en este caso se ignorará el test porque no se cumple
        //Lo que sigue en este test, no se va a ejecutar salvo que cambiemos la assumption por una cierta
        assertThrows(IOException.class, () -> aritmetica.funcionQueLanzaUnError());
    }

    //Creamos un test de un ejemplo práctico del assumeTrue()
    @Test
    void ejemploAssumeTrue(){
        Aritmetica aritmetica = new Aritmetica();
// Obtenemos la lista de propiedades de sistema para despues acceder a elle. (lo comentamos)
//        System.out.println(System.getProperties()); // Muestra las propiedades de sistema por consola.

        String nombreOs = System.getProperty("os.name");

        //Comprobamos si el sistema operativo os.name es Windows 10
        assumeTrue(nombreOs.equalsIgnoreCase("Windows 10")); //se cumple que es verdadero
        System.out.println("\n** Estamos en un sistema operativo Windows 10");


        //Lo mismo con assumeFalse:
        assumeFalse(nombreOs.equalsIgnoreCase("Mac OS X")); //Se cumple que es falso
        System.out.println("\n** Este no es un sistema operativo Mac OS X\n");
    }

}