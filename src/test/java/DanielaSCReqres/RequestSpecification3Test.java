package DanielaSCReqres;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecification3Test {
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
                .get("api/users/7")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
