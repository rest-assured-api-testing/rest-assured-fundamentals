package Edson_Anawaya_Todoist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization2Test {
    private String token = "156721c42720001c6856e1afe292880e776ec1d5";
    @DataProvider(name = "testProvider")
    public static Object[][] testProvider1() {
        return new Object[][]{
                {"2267205393", "Inbox"},
                {"2267205394", "Welcome \uD83D\uDC4B"},
                {"2267214766", "Shopping List Update"},
                {"2267322023", "Shopping List 3"},
                {"2267322377", "Shopping List 4"},
                {"2267327255", "Shopping List 4"}
        };
    }


    @Test(dataProvider = "testProvider")
    public void testProjectNames(String id, String expectedResult) {
        given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id)
                .when()
                .get("https://api.todoist.com/rest/v1/projects/{id}")
                .then()
                .assertThat()
                .body("name", equalTo(expectedResult));
    }
}
