package starter;

public enum WebServiceEndPoints {
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
