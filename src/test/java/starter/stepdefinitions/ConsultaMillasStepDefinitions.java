package starter.stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.consulta.Consulta;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultaMillasStepDefinitions {

    @Steps
    Consulta consulta;

    @Given("el usuario accede a la aplicacion")
    public String generate_token(){
        String accessToken;
        consulta.generateToken();
        accessToken = SerenityRest.lastResponse().path("access_token").toString();

        return accessToken;
    }

    @When("^el usuario consulta su tarjeta \"([^\"]*)\"$")
    public void consultar_millas(String numeroTarjeta){
        String accessToken = generate_token();
        consulta.consultarMillas(accessToken, numeroTarjeta);
        //restAssuredThat(response -> response.statusCode(200));
    }

    @Then("^el usuario \"([^\"]*)\" obtiene su saldo de millas$")
    public void obtener_millas(String condicion){

        consulta.validarSaldo(condicion);

    }

}
