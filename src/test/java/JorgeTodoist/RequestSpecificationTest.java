package JorgeTodoist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTest {
    private RequestSpecification requestSpecification;

    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/")
                .build();
    }

    @Test
    public void codeTest() {
        given()
                .spec(requestSpecification)
                .auth()
                .oauth2("0c15909dcdf9d6e60767fc261a78335a9477506a")
                .when()
                .get("rest/v1/projects/2267238674")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
