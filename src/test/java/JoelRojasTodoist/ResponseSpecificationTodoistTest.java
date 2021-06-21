package JoelRojasTodoist;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecificationTodoistTest {

    private ResponseSpecification responseSpecification;

    @BeforeClass
    public void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void testProjectName() {
        given()
                .header("Authorization", "Bearer acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8")
                .when()
                .get("https://api.todoist.com/rest/v1/projects/2267325200")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("name", equalTo("Created Project Form intellij"));
    }
}
