package starter.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.visa.CanjeMillas;

public class CanjeMillasStepDefinitions {

    @Steps
    CanjeMillas canje;

    @When("el usuario ingresa su tarjeta \"([^\"]*)\", cantidad de millas \"([^\"]*)\", tipo de documento \"([^\"]*)\" y número \"([^\"]*)\"$")
    public void canjear_millas (String numeroTarjeta, String cantidadMillas, String tipoDocumento, String numeroDocumento){
        String accessToken = SerenityRest.lastResponse().path("access_token").toString();
        canje.canjearMillas(accessToken, numeroTarjeta, cantidadMillas, tipoDocumento, numeroDocumento);

    }

    @Then("el canje de millas es satisfactorio")
    public void validar_canje(){
        canje.validarCanje();
    }
}
