package cristianChoque;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class TestAPI {

    @Test
    public void test1() {
        given()
                .log().all()
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .when()
                .get("https://api.todoist.com/rest/v1/projects")
                .then()
                .log().body();
    }

    private static String requestBodyCreateProject = "{\n" +
            "  \"name\": \"project created from java\" \n}";

    @Test
    public void test2() {
        given()
                .header("Content-type", "application/json")
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .and()
                .body(requestBodyCreateProject)
                .when()
                .post("https://api.todoist.com/rest/v1/projects")
                .then()
                .extract().response();
    }

    @Test
    public void test3() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .param("id", "2267234459")
                .when()
                .get("https://api.todoist.com/rest/v1/projects")
                .then()
                .log().body()
                .extract().response();
    }

    private static String requestBodyUpdateProject = "{\n" +
            "  \"name\": \"shopping list 1\",\n" +
            "  \"color\": 47,\n" +
            "  \"favorite\": false \n}";

    @Test
    public void test4() {
        given()
                .header("Content-type", "application/json")
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .and()
                .body(requestBodyUpdateProject)
                .when()
                .post("https://api.todoist.com/rest/v1/projects/2267234459")
                .then()
                .extract().response();
    }
}
