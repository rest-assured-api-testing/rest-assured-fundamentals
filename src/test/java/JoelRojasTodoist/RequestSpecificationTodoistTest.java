package JoelRojasTodoist;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTodoistTest {
    private RequestSpecification requestSpecification;

    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/rest/v1/")
                .build();
    }

    @Test
    public void testRequestStatus() {
        given()
                .spec(requestSpecification)
                .auth()
                .oauth2("acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8")
                .when()
                .get("projects")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
