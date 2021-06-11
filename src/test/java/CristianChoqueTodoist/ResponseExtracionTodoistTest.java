package CristianChoqueTodoist;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseExtracionTodoistTest {

    private RequestSpecification requestSpecification;

    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/rest/v1/")
                .build();
    }

    @Test
    public void test2() {
        String placeName = given()
                .header("Content-type", "application/json")
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .spec(requestSpecification)
                .when()
                .get("projects/2267202896")
                .then()
                .log().all()
                .extract()
                .path("name");

        Assert.assertEquals(placeName, "Prueba los Paneles");

    }
}

