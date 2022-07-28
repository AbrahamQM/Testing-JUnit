package ApiRest.JavaAvsesion27ArquitecturaLimpia.Controllers;

import ApiRest.JavaAvsesion27ArquitecturaLimpia.Entities.Usuario;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Services.UsuariosService;
import ApiRest.JavaAvsesion27ArquitecturaLimpia.Stadistics.UsuariosDBEstadisticas;
import org.json.*;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class UsuariosController {


    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarTodos(){return usuariosService.listarUsuarios();}

    @GET
    @Path("/usuarios/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario listarUno(@PathParam("nombre") String nombre){
        return usuariosService.obtenerUsuario(nombre);
    }
    
//    //Punto de entrada implementado por mí, que muestra las estadísticas en el terminal
    @GET
    @Path("/estadisticasenterminal")
    public void estadisticasEnTerminal(){
        System.out.println("Inserciones: " + (((UsuariosDBEstadisticas)(usuariosService.usuariosDB)).getTotalInserciones()));
        System.out.println("Eliminaciones: " + ((UsuariosDBEstadisticas)(usuariosService.usuariosDB)).getTotalEliminaciones());
    }
    @GET
    @Path("/estadisticas")
    @Produces(MediaType.APPLICATION_JSON)
    public String estadisticas()  {
        String respuesta = "";
        respuesta = ( "{" + '"' + "Inserciones"+ '"' + ": " + '"'+
                (((UsuariosDBEstadisticas) (usuariosService.usuariosDB)).getTotalInserciones()) + '"' + ","+
                '"' + "Eliminaciones" + '"' + ": " + '"' +
                ((UsuariosDBEstadisticas) (usuariosService.usuariosDB)).getTotalEliminaciones() + '"' + "}" );
        System.out.println(respuesta);
        return respuesta;
    }


    @POST
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario){
        usuariosService.crearUsuario(usuario);
        return Response.created(URI.create("/usuarios/" + usuario.nombreUsuario)).build();
    }

    @DELETE
    @Path("/usuarios/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(@PathParam("nombre") String nombre){
        usuariosService.borrarUsuario(nombre);
        return Response.ok().build();
    }
}
