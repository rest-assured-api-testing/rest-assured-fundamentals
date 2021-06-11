package juangonzales_reqres;

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
    public void test2() {
        given().queryParam("page","2")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("data[0].first_name", equalTo("Michael"));
    }
}
