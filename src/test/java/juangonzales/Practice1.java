package juangonzales;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Practice1 {
    @Test
    public void test1() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .body("data[0].email", equalTo("michael.lawson@reqres.in"));
    }

    @Test
    public void test2() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test3() {
        given()
                .log().all()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body();
    }
}
