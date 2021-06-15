package DanielaSCReqres;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecification3Test {

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
                .when()
                .get("https://reqres.in/api/users/7")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("data.'email'", equalTo("michael.lawson@reqres.in"));
    }
}
