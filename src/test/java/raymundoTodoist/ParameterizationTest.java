package raymundoTodoist;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class ParameterizationTest {

    @DataProvider()
    public static Object[][] testProvider1() {
        return new Object[][]{
                {"2267209504", "Inbox"},
                {"2267209508", "Prueba los Paneles"},
                {"2267248454", "My New Project With a Different Name and favorite"},
                {"2267254954", "My Third Project"}
        };
    }

    @Test
    @UseDataProvider("testProvider1")
    public void test1(String projectId, String expectedResult) {
        given()
                .header("Content-type", "application/json")
                .auth()
                .oauth2("ad1055bfd0e8b0fc32d603e28d015044e5d65cc0")
                .pathParam("id", projectId)
                .when()
                .get("https://api.todoist.com/rest/v1/projects/{id}")
                .then()
                .assertThat()
                .body("name", equalTo(expectedResult));
    }
}
