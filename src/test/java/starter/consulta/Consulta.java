package starter.consulta;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.WebServiceEndPoints;

public class Consulta {

    @Step("el usuario accede a la aplicacion")
    public void generateToken(){
        SerenityRest.given()
                .contentType("application/x-www-form-urlencoded")
                .header("X-IB-Client-Id", "dd4227301f944964ba30dc5cd73e9a82")
                .body("grant_type=client_credentials&client_secret=3%40oQfu9x%40Ke79V%40vCQ%3ALbUnrgltEiLgT&client_id=b4670cca-c5f4-4de9-a640-481bc94b7d12")
                .when()
                .post(WebServiceEndPoints.GENERATE_TOKEN.getUrl());
    }

    @Step("When el usuario consulta su tarjeta {string}")
    public void consultarMillas(String accessToken, String numeroTarjeta) {
        SerenityRest.given()
                .header("Authorization","Bearer " + accessToken)
                .header("X-IB-Client-Id","dd4227301f944964ba30dc5cd73e9a82")
                .header("X-INT-Device-Id","127.0.0.1")
                .header("X-INT-Timestamp","2030-11-29T14:39:22.925769+00:00")
                .header("X-INT-Consumer-Id","NBZ")
                .param("code","7777777777777")
                .param("name", "NORMAC")
                .param("terminal", "123")
                .param("externalTrxId","517789")
                .when()
                .get(WebServiceEndPoints.CONSULTA_MILLAS.getUrl()+numeroTarjeta)
                .then()
                .statusCode(200);

    }

    public void validarSaldo(String response) {
    }
}
