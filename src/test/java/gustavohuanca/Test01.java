package gustavohuanca;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
    public void test4() {
        given()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .assertThat()
                .body("data.'iso'", hasItem("USA"));
    }

    @Test
    public void test5() {
        given()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .assertThat()
                .body("data", hasSize(215));
    }

    @Test
    public void test6() {
        given()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .assertThat()
                .body("data[120].'name'", not(equalTo("South Sudan")));
    }

    @Test
    public void test7() {
        given()
                .log().all()
                .when()
                .get("https://covid-api.com/api/regions")
                .then()
                .log().body();
    }
}
