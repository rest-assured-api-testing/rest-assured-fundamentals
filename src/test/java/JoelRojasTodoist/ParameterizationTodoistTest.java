package JoelRojasTodoist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParameterizationTodoistTest {
    @DataProvider(name = "testProvider")
    public static Object[][] testProvider1() {
        return new Object[][]{
                {"2267203086", "Inbox"},
                {"2267203087", "Te damos la bienvenida \uD83D\uDC4B"},
                {"2267203088", "Prueba los Paneles"},
                {"2267236196", "Test List"}
        };
    }


    @Test(dataProvider = "testProvider")
    public void testProjectNames(String id, String expectedResult) {
        given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8")
                .pathParam("id", id)
                .when()
                .get("https://api.todoist.com/rest/v1/projects/{id}")
                .then()
                .assertThat()
                .body("name", equalTo(expectedResult));
    }
}
