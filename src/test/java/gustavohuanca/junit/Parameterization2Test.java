package gustavohuanca.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization2Test {

    public static Object[][] testProvider(){
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }

    @ParameterizedTest
    @MethodSource("testProvider")
    public void test1(String countryCode, String zipCode, String expectedResult){
        given()
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
           .when()
                .get("http://zippopotam.us/{countryCode}/{zipCode}")
        .then()
                .assertThat()
                .body("places[0].'place name'", equalTo(expectedResult));
    }
}
