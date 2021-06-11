package jessicka_moya_todoist;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class ParameterizationJUnitTest {
    @DataProvider
    public static Object[][] testProvider() {
        return new Object[][]{
                {"4895975362", "Task without a section edited"},
                {"4895978690", "Task in a section"},
                {"4895988581", "task to close and reopen"}
        };
    }

    @Test
    @UseDataProvider("testProvider")
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
