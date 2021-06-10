package gustavohuanca;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Test01 {
    @Test
    public void test1() {
        given()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .assertThat()
                .body("data[0].'iso'", equalTo("CHN"));
    }

    @Test
    public void test2() {
        given()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test3() {
        given()
                .log().all()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .log().body();
    }
}
