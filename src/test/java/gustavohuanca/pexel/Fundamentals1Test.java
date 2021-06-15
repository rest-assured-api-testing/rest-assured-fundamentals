package gustavohuanca.pexel;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Fundamentals1Test {
    @Test
    public void test1() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 563492ad6f91700001000001d9871aad8f0c4d47826d50de4ac1bfe1")
                .when()
                .get("https://api.pexels.com/v1/photos/2014422")
                .then()
                .assertThat()
                .body("src.'original'",
                        equalTo("https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg"));
    }

    @Test
    public void test2() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 563492ad6f91700001000001d9871aad8f0c4d47826d50de4ac1bfe1")
                .when()
                .get("https://api.pexels.com/v1/photos/2014422")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test3() {
        given()
                .contentType(ContentType.JSON)
                .header("Content-type", "application/json")
                .header("Authorization",
                        "Bearer 563492ad6f91700001000001d9871aad8f0c4d47826d50de4ac1bfe1")
                .when()
                .get("https://api.pexels.com/v1/photos/2014422")
                .then()
                .log().body();

    }
}
