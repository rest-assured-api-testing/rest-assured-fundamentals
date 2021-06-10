package PaolaAguilar;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTests {
    @Test
    public void CoinGeckoConnection() {
        given()
                .when()
                .get("https://api.coingecko.com/api/v3/ping")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void CoinGeckoLog() {
        given()
                .log().all()
                .when()
                .get("https://api.coingecko.com/api/v3/simple/supported_vs_currencies")
                .then()
                .log().body();
    }

    @Test
    public void GeckoCoinTestBody() {
        given()
                .when()
                .get("https://api.coingecko.com/api/v3/exchanges/aave")
                .then()
                .assertThat()
                .body("name", equalTo("Aave"));
    }

}
