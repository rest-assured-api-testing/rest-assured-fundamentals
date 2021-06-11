package juangonzales_reqres;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseExtractionTest {

    private RequestSpecification requestSpecification;

    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .build();
    }

    @Test
    public void test2() {
        String placeName = given()
                .spec(requestSpecification)
                .when()
                .get("api/users?page=2")
                .then()
                .log().all()
                .extract()
                .path("data[0].email");

        Assert.assertEquals(placeName, "michael.lawson@reqres.in");

    }
}
