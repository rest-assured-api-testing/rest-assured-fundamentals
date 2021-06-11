package gustavohuanca.pexel;

import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization2Test {

    public static Object[][] testProvider() {
        return new Object[][]{
                {"2014422", "Joey Farina"},
                {"2014300", "Bruno Bueno"},
                {"2012500", "Eliza Kira  Erzse"}
        };
    }

    @ParameterizedTest
    @MethodSource("testProvider")
    public void test1(String id, String expectedResult) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 563492ad6f91700001000001d9871aad8f0c4d47826d50de4ac1bfe1")
                .pathParam("id", id)
                .when()
                .get("https://api.pexels.com/v1/photos/{id}")
                .then()
                .assertThat()
                .body("photographer", equalTo(expectedResult));
    }
}
