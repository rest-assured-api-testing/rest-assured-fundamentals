package JoelRojasTodoist;

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
    public void testProjectName() {
        String placeName = given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8")
                .when()
                .get("projects/2267245800")
                .then()
                .log().all()
                .extract()
                .path("name");

        Assert.assertEquals(placeName, "Things To Buy");

    }
}
