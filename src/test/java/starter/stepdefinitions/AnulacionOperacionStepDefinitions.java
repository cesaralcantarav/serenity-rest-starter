package starter.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.visa.AnulacionOperacion;
import starter.visa.ConsultaMillas;

public class AnulacionOperacionStepDefinitions {

    @Steps
    ConsultaMillasStepDefinitions consultaSteps;

    @Steps
    AnulacionOperacion anulacion;

    @When("el usuario anula la operacion de su tarjeta \"([^\"]*)\"$")
    public void anular_canje(String numeroTarjeta){

        String operationId = SerenityRest.lastResponse().path("operationId").toString();
        consultaSteps.generate_token();
        String accessToken = SerenityRest.lastResponse().path("access_token").toString();
        anulacion.anularCanje(accessToken, numeroTarjeta, operationId);

    }

    @Then("^la anulacion de canje de millas de su tarjeta \"([^\"]*)\" es satisfactoria$")
    public void validar_anulacion(String numeroTarjeta){
        String millas = SerenityRest.lastResponse().path("miles").toString();
        consultaSteps.consultar_millas(numeroTarjeta);
        String consultaMillas = SerenityRest.lastResponse().path("miles").toString();
        anulacion.validarAnulacion(millas, consultaMillas);
    }


}
