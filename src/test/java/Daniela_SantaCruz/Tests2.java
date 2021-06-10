package Daniela_SantaCruz;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tests2 {
    private static String requestBody = "{\n" +
            "  \"name\": \"morpheuss2\",\n" +
            "  \"job\": \"leader\" \n}";
    @Test
    public void test1() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .body("data[0].'email'", equalTo("michael.lawson@reqres.in"));
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

    @Test
    public void test4() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .log().all()
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().body();
    }

    @Test
    public void test5() {
        given()
                .header("Content-type", "application/json")
                .when()
                .delete("https://reqres.in/api/users/437")
                .then()
                .assertThat()
                .statusCode(204);
    }

    @Test
    public void test6() {
        given()
                .when()
                .get("https://reqres.in/api/users/437")
                .then()
                .assertThat()
                .statusCode(404);
    }
}
