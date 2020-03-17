package starter.stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.visa.ConsultaMillas;

public class ConsultaMillasStepDefinitions {

    @Steps
    ConsultaMillas consulta;

    @Given("el usuario accede a la aplicacion")
    public void generate_token(){

        consulta.generateToken();

    }

    @When("^el usuario consulta su tarjeta \"([^\"]*)\"$")
    public void consultar_millas(String numeroTarjeta){

        generate_token();
        String accessToken = SerenityRest.lastResponse().path("access_token").toString();
        consulta.consultarMillas(accessToken, numeroTarjeta);
        //restAssuredThat(response -> response.statusCode(200));

    }

    @Then("^el usuario \"([^\"]*)\" obtiene su saldo de millas$")
    public void obtener_millas(String condicion){

        consulta.validarSaldo(condicion);

    }

}
