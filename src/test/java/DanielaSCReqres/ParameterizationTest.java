package DanielaSCReqres;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class ParameterizationTest {

    @DataProvider
    public static Object[][] testProvider() {
        return new Object[][]{
                {"7", "michael.lawson@reqres.in"},
                {"8", "lindsay.ferguson@reqres.in"},
                {"9", "tobias.funke@reqres.in"},
                {"10", "byron.fields@reqres.in"}
        };
    }

    @Test
    @UseDataProvider("testProvider")
    public void test1(String id, String expectedResult) {
        given()
                .pathParam("id", id)
                .when()
                .get("https://reqres.in/api/users/{id}")
                .then()
                .assertThat()
                .body("data.'email'", equalTo(expectedResult));
    }
}
