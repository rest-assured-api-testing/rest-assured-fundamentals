package CristianChoqueTodoist;

//public class ResponseSpecificationTodoistTest {
//}

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
    public void test2() {
        given()
                .header("Content-type", "application/json")
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .when()
                .get("https://api.todoist.com/rest/v1/projects/2267202896")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("name", equalTo("Prueba los Paneles"));
    }
}
