import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecification3Test {
    private RequestSpecification requestSpecification;

//    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://zippopotam.us/")
                .build();
    }

//    @Test
    public void test2() {
        given()
                .spec(requestSpecification)
                .when()
                .get("us/90210")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
