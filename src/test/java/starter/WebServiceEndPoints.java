package starter;

public enum WebServiceEndPoints {
    STATUS("http://localhost:8080/api/status"),
    TRADE("http://localhost:8080/api/trade"),
    GENERATE_TOKEN("https://apis.uat.interbank.pe/api/token/v1/oauth"),
    CONSULTA_MILLAS("https://apis.uat.interbank.pe/benefit/millas/v1/");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
