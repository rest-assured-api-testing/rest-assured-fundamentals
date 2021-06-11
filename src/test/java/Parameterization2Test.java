import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class Parameterization2Test {

    @DataProvider
    public static Object[][] testProvider1() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
                {"nl", "1001", "Amsterdam"}
        };
    }

    @Test
    @UseDataProvider("testProvider1")
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
