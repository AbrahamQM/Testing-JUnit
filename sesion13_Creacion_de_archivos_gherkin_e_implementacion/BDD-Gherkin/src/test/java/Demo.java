import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Demo {
    List<Map<String, String>> credenciales;
    @Given("El usuario va a pagar con uno de estos metodos")
    public void el_usuario_va_a_pagar_con_uno_de_estos_metodos(List<String> paymentMethod) {
        for(String metodo : paymentMethod){
            System.out.println("Método de pago escogido: " + metodo);
        }
    }
    @When("Solicitamos que realice el pago")
    public void solicitamos_que_realice_el_pago() {

    }
    @Then("Verificamos el metodo seleccionado")
    public void verificamos_el_metodo_seleccionado() {

    }

    //Escenario 2
    @Given("Los pares de usuario y clave")
    public void los_pares_de_usuario_y_clave(List<Map<String, String>> credenciales) {
        this.credenciales = credenciales;
    }
    @When("el usuario los envie")
    public void el_usuario_los_envie() {
        for (Map<String, String> actual : credenciales){
            sanitizar(actual.get("username"));
            sanitizar(actual.get("password"));
        }
    }

    private String sanitizar(String datos){
        return datos.trim();
    }

    @Then("los verificamos con el backEnd")
    public boolean los_verificamos_con_el_back_end() {
        for (Map<String, String> actual : credenciales){
            return checkCredentials(actual.get("username"), actual.get("password"));
        }
        return false;
    }

    private boolean checkCredentials(String usuario, String clave){
        return true;
    }
}
