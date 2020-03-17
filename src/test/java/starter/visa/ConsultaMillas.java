package starter.visa;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.WebServiceEndPoints;

public class ConsultaMillas {

    private Response r;
    private String ibClientId = "dd4227301f944964ba30dc5cd73e9a82";

    @Step("el usuario accede a la aplicacion")
    public void generateToken(){
         r = SerenityRest.given()
                 .contentType("application/x-www-form-urlencoded")
                 .header("X-IB-Client-Id", ibClientId)
                 .body("grant_type=client_credentials&client_secret=3%40oQfu9x%40Ke79V%40vCQ%3ALbUnrgltEiLgT&client_id=b4670cca-c5f4-4de9-a640-481bc94b7d12")
                 .when()
                 .post(WebServiceEndPoints.GENERATE_TOKEN.getUrl());
        String response = r.getBody().asString();
        System.out.println("API: >>>>>>>>>>>>>> " + WebServiceEndPoints.GENERATE_TOKEN.getUrl());
        System.out.println("\nCurrent response >>>>>>>>>>>> " + response);
    }

    @Step("When el usuario consulta su tarjeta {string}")
    public void consultarMillas(String accessToken, String numeroTarjeta) {
         r = SerenityRest.given().
                 header("Authorization","Bearer " + accessToken)
                .header("X-IB-Client-Id", ibClientId )
                .header("X-INT-Device-Id","127.0.0.1")
                .header("X-INT-Timestamp","2030-11-29T14:39:22.925769+00:00")
                .header("X-INT-Consumer-Id","NBZ")
                .param("code","7777777777777")
                .param("name", "NORMAC")
                .param("terminal", "123")
                .param("externalTrxId","517789")
                .when()
                .get(WebServiceEndPoints.CONSULTA_MILLAS.getUrl()+numeroTarjeta);

        String response = r.getBody().asString();
        System.out.println("API >>>>>>>>> " + WebServiceEndPoints.CONSULTA_MILLAS.getUrl());
        System.out.println("\nCurrent response >>>>>>>>> " + response);
    }

    @Step("Then el usuario {string} obtiene su saldo de millas")
    public void validarSaldo(String condicion) {

        if (condicion.equals("si")){
            r.then().statusCode(200);
            Assert.assertEquals(r.getBody().asString().contains("miles"), true);
        }
        else {
            r.then().statusCode(403);
        }

    }
}
