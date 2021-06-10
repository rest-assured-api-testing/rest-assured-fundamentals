package Edson_Anawaya;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class Edson_Anawaya_Tests {
    private String token = "156721c42720001c6856e1afe292880e776ec1d5";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://swapi.dev/api";
    }


    @Test
    public void ListAPeople() {
        get("/people/1").then().statusCode(200).assertThat()
                .body("name", equalTo("Luke Skywalker"));
    }

    @Test
    public void ListAPeopleWithStatus() {
        Response response = given()
                .when()
                .get("/people/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Luke Skywalker", response.jsonPath().getString("name"));
    }

    @Test
    public void ListAVehicle() {
        Response response = given()
                .when()
                .get("/vehicles/14")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Snowspeeder", response.jsonPath().getString("name"));
        Assertions.assertEquals("t-47 airspeeder", response.jsonPath().getString("model"));
        Assertions.assertEquals("Incom corporation", response.jsonPath().getString("manufacturer"));
        Assertions.assertEquals("650", response.jsonPath().getString("max_atmosphering_speed"));
    }

    @Test
    public void FailGetAVehicle() {
        Response response = given()
                .when()
                .get("/vehicles/1")
                .then()
                .extract().response();

        Assertions.assertEquals(404, response.statusCode());
        Assertions.assertEquals("Not found", response.jsonPath().getString("detail"));
    }

    @Test
    public void GetListAllProjects() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.todoist.com/rest/v1/projects")
                .then()
                .assertThat()
                .log().body();
    }

    @Test
    public void PostAddANewProject() {
        String requestBody = "{\n" +
                "  \"name\": \"Shopping List 4\" \n}";
        given()
                .header("Authorization", "Bearer " + token)
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("https://api.todoist.com/rest/v1/projects")
                .then()
                .assertThat()
                .body("name", equalTo("Shopping List 4"))
                .body("shared", equalTo(false));
    }

    @Test
    public void DeleteAProject() {
        given()
                .header("Authorization", "Bearer " + token)
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete("https://api.todoist.com/rest/v1/projects/2267322240")
                .then()
                .assertThat()
                .statusCode(204);
    }
}
