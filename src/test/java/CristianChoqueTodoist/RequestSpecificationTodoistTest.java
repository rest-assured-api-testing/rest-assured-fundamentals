package CristianChoqueTodoist;

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
    public void test2() {
        given()
                .header("Content-type", "application/json")
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .spec(requestSpecification)
                .when()
                .get("projects")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
