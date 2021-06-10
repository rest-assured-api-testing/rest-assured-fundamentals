package JorgeCaceres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class apiTest {
    @Test
    public void loginTest() {
        String body = "{\n" +
                "    \"username\": \"api\",\n" +
                "    \"password\": \"11add37ede2662213851a45e5a0d5228\",\n" +
                "    \"port\": \"8260\",\n" +
                "    \"version\": \"1.0.2\",\n" +
                "    \"url\": \"110.22.2.3:8260/report\",\n" +
                "    \"urltag\": \"1\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://omjq01.us.yeastarcloud.com/api/v1.1.0/login")
                .then()
                .assertThat()
                .body("status", equalTo("Success"));
    }
    @Test
    public void loginStatusCode() {
        String body = "{\n" +
                "    \"username\": \"api\",\n" +
                "    \"password\": \"11add37ede2662213851a45e5a0d5228\",\n" +
                "    \"port\": \"8260\",\n" +
                "    \"version\": \"1.0.2\",\n" +
                "    \"url\": \"110.22.2.3:8260/report\",\n" +
                "    \"urltag\": \"1\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://omjq01.us.yeastarcloud.com/api/v1.1.0/login")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void loginLogAll() {
        String body = "{\n" +
                "    \"username\": \"api\",\n" +
                "    \"password\": \"11add37ede2662213851a45e5a0d5228\",\n" +
                "    \"port\": \"8260\",\n" +
                "    \"version\": \"1.0.2\",\n" +
                "    \"url\": \"110.22.2.3:8260/report\",\n" +
                "    \"urltag\": \"1\"\n" +
                "}";
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://omjq01.us.yeastarcloud.com/api/v1.1.0/login")
                .then()
                .log().body();
    }
}
