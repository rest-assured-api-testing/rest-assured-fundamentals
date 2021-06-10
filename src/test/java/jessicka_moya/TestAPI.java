package jessicka_moya;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestAPI {
    @Test
    public void test1() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?participants=2")
                .then()
                .assertThat()
                .body("'participants'", not(equalTo("3")));
    }

    @Test
    public void test2() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?key=7806284")
                .then()
                .assertThat()
                .body("'activity'", equalTo("Fill out a basketball bracket"));
    }

    @Test
    public void test3() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity/")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test4() {
        given()
                .log().all()
                .when()
                .get("http://www.boredapi.com/api/activity")
                .then()
                .log().body();
    }

    @Test
    public void test5() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?key=4179309")
                .then()
                .assertThat()
                .body("'activity'", containsString("states"));
    }

    @Test
    public void test6() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?key=3149232")
                .then()
                .assertThat()
                .body("'activity'", allOf(startsWith("Go"), containsString("friends")));
    }

    @Test
    public void test7() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?key=5914292")
                .then()
                .assertThat()
                .body("'activity'", anyOf(startsWith("Host"), containsString("string")));
    }

    @Test
    public void test8() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?key=9999999")
                .then()
                .assertThat()
                .body("'activity'", both(containsString("problem")).and(containsString("Resolve")));
    }

    @Test
    public void test9() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity")
                .then()
                .assertThat()
                .body("'type'", is(not(nullValue())));
    }

    @Test
    public void test10() {
        given()
                .when()
                .get("http://www.boredapi.com/api/activity?key=5585829")
                .then()
                .assertThat()
                .body("'participants'", greaterThan(1));
    }
}
