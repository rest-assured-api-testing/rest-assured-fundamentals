import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseExtracion5Test {

    private RequestSpecification requestSpecification;

//    @BeforeClass
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://zippopotam.us/")
                .build();
    }

//    @Test
    public void test2() {
        String placeName = given()
                .spec(requestSpecification)
                .when()
                .get("us/90210")
                .then()
                .log().all()
                .extract()
                .path("places[0].'place name'");

//        Assert.assertEquals(placeName, "Beverly Hills");

    }
}
