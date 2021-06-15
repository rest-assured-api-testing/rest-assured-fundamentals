package jessicka_moya_todoist;

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
                .setBaseUri("https://api.todoist.com/rest/v1/")
                .build();
    }

    @Test
    public void testStatusCodeOfSection() {
        given()
                .spec(requestSpecification)
                .auth()
                .oauth2("3c72b9a42be1313c3f48e58c42d1e0290e475d5b")
                .when()
                .get("sections/51072657")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
