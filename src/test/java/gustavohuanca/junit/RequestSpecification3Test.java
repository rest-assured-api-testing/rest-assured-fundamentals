package gustavohuanca.junit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecification3Test {
    private static RequestSpecification requestSpecification;

    @BeforeAll
    public static void  createRequestSpecification(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://zippopotam.us/")
                .build();
    }

    @Test
    public void test2(){
        given()
                .spec(requestSpecification)
                .when()
                .get("us/90210")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
