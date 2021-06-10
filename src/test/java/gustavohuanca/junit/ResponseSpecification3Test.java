package gustavohuanca.junit;

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
    public static void createResponseSpecification(){
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void test2(){
        given()
        .when()
                .get("http://zippopotam.us/us/90210")
        .then()
                .spec(responseSpecification)
                .assertThat()
                .log().all()
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }
}
