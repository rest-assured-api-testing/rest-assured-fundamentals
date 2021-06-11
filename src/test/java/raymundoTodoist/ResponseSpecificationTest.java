package raymundoTodoist;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecificationTest {
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void test2() {
        given()
                .when()
                .auth()
                .oauth2("ad1055bfd0e8b0fc32d603e28d015044e5d65cc0")
                .get("https://api.todoist.com/rest/v1/projects/2267248454")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("name", equalTo("My New Project With a Different Name and favorite"));
    }
}
