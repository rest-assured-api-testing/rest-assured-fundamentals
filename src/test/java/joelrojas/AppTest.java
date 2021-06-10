package joelrojas;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {
    @Test
    public void testStatus() {
        given()
                .header("Authorization", "Bearer acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8")
                .when()
                .get("https://api.todoist.com/rest/v1/projects")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testProjects() {
        given()
                .log().all()
                .header("Authorization", "Bearer acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8")
                .when()
                .get("https://api.todoist.com/rest/v1/projects")
                .then()
                .log().body();
    }
}
