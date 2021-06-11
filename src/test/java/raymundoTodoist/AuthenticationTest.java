package raymundoTodoist;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;

public class AuthenticationTest {
    @Test
    public void testLogin() {
        baseURI = "https://api.todoist.com/rest/v1/projects";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .auth()
                .oauth2("ad1055bfd0e8b0fc32d603e28d015044e5d65cc0")
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
