package jessicka_moya_todoist;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParameterizationTestNGTest {
    @DataProvider(name = "testProvider")
    public static Object[][] testProvider() {
        return new Object[][]{
                {"4895975362", "Task without a section edited"},
                {"4895978690", "Task in a section"},
                {"4895988581", "task to close and reopen"}
        };
    }


    @Test(dataProvider = "testProvider")
    public void testTaskName(String id, String expectedResult) {
        given()
                .auth()
                .oauth2("3c72b9a42be1313c3f48e58c42d1e0290e475d5b")
                .pathParam("id", id)
                .when()
                .get("https://api.todoist.com/rest/v1/tasks/{id}")
                .then()
                .assertThat()
                .body("'content'", equalTo(expectedResult));
    }
}
