package juangonzales_reqres;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTest {
    private RequestSpecification requestSpecification;

    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .build();
    }

    @Test
    public void test2() {
        given()
                .spec(requestSpecification)
                .when()
                .get("api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
