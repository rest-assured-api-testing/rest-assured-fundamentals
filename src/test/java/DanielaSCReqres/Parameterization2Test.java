package DanielaSCReqres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization2Test {

    @DataProvider(name = "testProvider")
    public static Object[][] usersProvider() {
        return new Object[][]{
                {"7", "michael.lawson@reqres.in"},
                {"8", "lindsay.ferguson@reqres.in"},
                {"9", "tobias.funke@reqres.in"}
        };
    }

    @Test(dataProvider = "testProvider")
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
