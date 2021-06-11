//import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tests {
//    @Test
    public void test1() {
        given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }

//    @Test
    public void test2() {
        given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .assertThat()
                .statusCode(200);
    }

//    @Test
    public void test3() {
        given()
                .log().all()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .log().body();
    }

}
