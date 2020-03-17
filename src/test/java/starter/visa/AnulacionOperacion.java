package starter.visa;

import com.google.gson.JsonObject;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.WebServiceEndPoints;

public class AnulacionOperacion {

    private Response r;
    private String ibClientId = "dd4227301f944964ba30dc5cd73e9a82";

    @Step("When el usuario anula la operacion de su tarjeta {string}")
    public void anularCanje(String accessToken, String numeroTarjeta, String operationId) {

        System.out.println("API >>>>>>>>> " + WebServiceEndPoints.CONSULTA_MILLAS.getUrl() + operationId + "/annulment");

        JsonObject payload = new JsonObject();
        payload.addProperty("cardId", numeroTarjeta);

        JsonObject commerce = new JsonObject();
        commerce.addProperty("code", "1");
        commerce.addProperty("name", "Comercio de prueba");

        payload.add("commerce", commerce);
        payload.addProperty("terminal", "2222222");
        payload.addProperty("externalTrxId", "23232");

        System.out.println("\nPayload: " + payload);

        r = SerenityRest.given()
                .header("Authorization","Bearer " + accessToken)
                .header("X-IB-Client-Id", ibClientId)
                .header("X-INT-Device-Id", "127.0.0.1")
                .header("X-INT-Timestamp", "2030-11-29T14:39:22.925769+00:00")
                .header("X-INT-Consumer-Id", "NBZ")
                .header("X-INT-Message-Id", "2018071802413200750")
                .body(payload.toString())
                .when()
                .put(WebServiceEndPoints.CONSULTA_MILLAS.getUrl() + operationId + "/annulment");

        String response = r.getBody().asString();
        System.out.println("\nCurrent response >>>>>>>>> " + response);

    }

    @Then("la anulacion de canje de millas de su tarjeta es satisfactoria")
    public void validarAnulacion(String millas, String consultaMillas) {

        r.then().statusCode(200);
        Assert.assertEquals(millas, consultaMillas);
        Assert.assertNotNull(r.jsonPath().get("operationId"));

    }
}
