//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization2Test {

//    @DataProvider(name = "testProvider")
    public static Object[][] testProvider1() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
                {"nl", "1001", "Amsterdam"}
        };
    }


//    @Test(dataProvider = "testProvider")
    public void test1(String countryCode, String zipCode, String expectedResult) {
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
