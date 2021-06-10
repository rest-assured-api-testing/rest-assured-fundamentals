package gustavohuanca.junit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseExtraction5Test {
    private static RequestSpecification requestSpecification;
    @BeforeAll
    public static void createRequestSpecification(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://zippopotam.us/")
                .build();
    }

    @Test
    public void test2(){
        String placeName = given()
                .spec(requestSpecification)
                .when()
                .get("us/90210")
                .then()
                .extract()
                .path("places[0].'place name'");

        assertEquals(placeName, "Beverly Hills");
    }
}
