package jessicka_moya_todoist;

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
    public void testSectionName() {
        given()
                .auth()
                .oauth2("3c72b9a42be1313c3f48e58c42d1e0290e475d5b")
                .when()
                .get("sections/51072657")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("'name'", equalTo("Section One Edited"));
    }
}
