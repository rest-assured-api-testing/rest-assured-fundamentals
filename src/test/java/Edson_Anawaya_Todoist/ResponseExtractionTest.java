package Edson_Anawaya_Todoist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class ResponseExtractionTest {
    private RequestSpecification requestSpecification;
    private String token = "156721c42720001c6856e1afe292880e776ec1d5";

    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/rest/v1/")
                .build();
    }

    @Test
    public void testProjectName() {
        String placeName = given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("projects/2267214766")
                .then()
                .log().all()
                .extract()
                .path("name");

        Assert.assertEquals(placeName, "Shopping List Update");

    }
}
