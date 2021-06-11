package DanielaSCReqres;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseExtracion5Test {

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
                .get("api/users/7")
                .then()
                .log().all()
                .extract()
                .path("data.'email'");

        Assert.assertEquals(placeName, "michael.lawson@reqres.in");

    }
}
