package Edson_Anawaya_Todoist;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTest {
    private RequestSpecification requestSpecification;
    private String token = "156721c42720001c6856e1afe292880e776ec1d5";

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
                .oauth2(token)
                .when()
                .get("projects")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
