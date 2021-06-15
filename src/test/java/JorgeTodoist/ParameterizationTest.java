package JorgeTodoist;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class ParameterizationTest {
    @DataProvider
    public static Object[][] testProvider() {
        return new Object[][]{
                {"rest","v1", "projects", "2267238674","Inbox"},
                {"rest","v1","projects", "2267238675","Te damos la bienvenida \uD83D\uDC4B"},
                {"rest","v1","projects", "2267238676","Prueba los Paneles"},
        };
    }
    @Test
    @UseDataProvider("testProvider")
    public void test(String apitype, String version, String projects, String projectId, String projectName) {
        given()
                .auth()
                .oauth2("0c15909dcdf9d6e60767fc261a78335a9477506a")
                .pathParam("apitype", apitype)
                .pathParam("version", version)
                .pathParam("projects", projects)
                .pathParam("projectId", projectId)
                .when()
                .get("https://api.todoist.com/{apitype}/{version}/{projects}/{projectId}")
                .then()
                .assertThat()
                .body("name", equalTo(projectName));
    }
}
