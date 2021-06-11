package raymundoTodoist;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ResponseExtractionTest {
    private static RequestSpecification requestSpecification;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/rest/v1/")
                .build();
    }

    @Test
    public void test2() {
        String placeName = given()
                .spec(requestSpecification)
                .when()
                .auth()
                .oauth2("ad1055bfd0e8b0fc32d603e28d015044e5d65cc0")
                .get("projects/2267248454")
                .then()
                .log().all()
                .extract()
                .path("name");
        Assert.assertEquals(placeName, "My New Project With a Different Name and favorite");
    }
}
