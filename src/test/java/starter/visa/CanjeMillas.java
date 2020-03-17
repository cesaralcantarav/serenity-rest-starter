package starter.visa;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.json.Json;
import starter.WebServiceEndPoints;

public class CanjeMillas {

    private Response r;
    private String ibClientId = "dd4227301f944964ba30dc5cd73e9a82";

    @Step("When el usuario ingresa su tarjeta {string}, cantidad de millas {double}, tipo de documento {int} y número {string}")
    public void canjearMillas(String accessToken, String numeroTarjeta, String cantidadMillas, String tipoDocumento, String numeroDocumento) {

        JsonObject product = new JsonObject();
        product.addProperty("miles", cantidadMillas);

        JsonObject commerce = new JsonObject();
        commerce.addProperty("code", "1");
        commerce.addProperty("name", "Comercio de prueba");

        JsonObject client = new JsonObject();
        client.addProperty("documentType", tipoDocumento);
        client.addProperty("documentNumber", numeroDocumento);

        JsonObject payload = new JsonObject();
        payload.add("product", product);
        payload.add("commerce", commerce);
        payload.add("client", client);
        payload.addProperty("terminal", "2222222");
        payload.addProperty("externalTrxId", "23232");


        System.out.println("\nPayload: " + payload);

        r = (Response) SerenityRest.given()
                .header("Authorization","Bearer " + accessToken)
                .header("X-IB-Client-Id", ibClientId)
                .header("X-INT-Device-Id", "127.0.0.1")
                .header("X-INT-Timestamp", "2030-11-29T14:39:22.925769+00:00")
                .header("X-INT-Consumer-Id", "NBZ")
                .header("X-INT-Message-Id", "2018071802413200750")
                .body(payload.toString())
                .when()
                .put(WebServiceEndPoints.CONSULTA_MILLAS.getUrl() + numeroTarjeta + "/exchange");

        String response = r.getBody().asString();
        System.out.println("API >>>>>>>>> " + WebServiceEndPoints.CONSULTA_MILLAS.getUrl() + numeroTarjeta + "/exchange");
        System.out.println("\nCurrent response >>>>>>>>> " + response);
    }

    @Step("el canje de millas es satisfactorio")
    public void validarCanje() {
        r.then().statusCode(200);
    }
}
