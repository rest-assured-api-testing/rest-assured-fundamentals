package JorgeTodoist;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecificationTest {

    private ResponseSpecification responseSpecification;

    @BeforeClass
    public void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void bodyTest() {
        given()
                .when()
                .auth()
                .oauth2("0c15909dcdf9d6e60767fc261a78335a9477506a")
                .get("https://api.todoist.com/rest/v1/projects/2267238674")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("name", equalTo("Inbox"));
    }
}
