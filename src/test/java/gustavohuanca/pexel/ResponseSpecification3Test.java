package gustavohuanca.pexel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecification3Test {
    private static ResponseSpecification responseSpecification;

    @BeforeAll
    public static void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void test2() {
        given()
                .header("Authorization",
                        "Bearer 563492ad6f91700001000001d9871aad8f0c4d47826d50de4ac1bfe1")
                .when()
                .get("https://api.pexels.com/v1/photos/2014422")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("src.'original'",
                        equalTo("https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg"));
    }
}
