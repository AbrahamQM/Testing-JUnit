package ApiRest.JavaAvsesion27ArquitecturaLimpia.config;

//Aquí vamos a definir la configuración de nuestra api REST

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/") //Para decirle que este va a ser nuestro punto de entrada
@Component //Le indicamos que es un componente
public class JerseyConfig extends ResourceConfig { //Le indicamos que extiende la clase ResourceConfig
    //Creamos constructor
    public JerseyConfig(){
        this.packages("ApiRest.JavaAvsesion27ArquitecturaLimpia.Controllers");//Le indicamos la
        // ruta a los controladores ApiRest.JavaAvsesion27ArquitecturaLimpia.Controllers
    }
}
