package gustavohuanca.pexel;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class RequestSpecification3Test {
    private static RequestSpecification requestSpecification;

    @BeforeAll
    public static void createRequestSpecification(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.pexels.com/")
                .build();
    }

    @Test
    public void test2(){
        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 563492ad6f91700001000001d9871aad8f0c4d47826d50de4ac1bfe1")
                .when()
                .get("v1/photos/2014422")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
