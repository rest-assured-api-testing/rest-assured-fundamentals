package Edson_Anawaya_Todoist;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class ResponseSpecificationTest {
    private ResponseSpecification responseSpecification;
    private String token = "156721c42720001c6856e1afe292880e776ec1d5";
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
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.todoist.com/rest/v1/projects/2267322023")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("name", equalTo("Shopping List 3"));
    }
}
