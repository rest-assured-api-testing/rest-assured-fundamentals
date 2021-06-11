package juangonzales_reqres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParameterizationTestNG {

    @DataProvider(name = "testProvider")
    public static Object[][] testProvider1() {
        return new Object[][]{
                {"1","0","george.bluth@reqres.in"},
                {"1","1","janet.weaver@reqres.in"},
                {"2","0","michael.lawson@reqres.in"},
                {"2","1","lindsay.ferguson@reqres.in"},
        };
    }


    @Test(dataProvider = "testProvider")
    public void test1(String page, String pos, String email) {
        given()
                .queryParam("page", page)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .assertThat()
                .body("data["+pos+"].email", equalTo(email));
    }
}
