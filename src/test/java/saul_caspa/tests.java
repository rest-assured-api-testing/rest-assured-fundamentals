package saul_caspa;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;;

public class tests {
    public static String client_id = "5d3264da4bbf490c88851de14bc50954";
    public static String client_secret = "cf8820cde20e42b69fb85f06d1dc51a3";
    public static String token = "";

    public static String encode(String usr, String pss) {
        return new String(Base64.getEncoder().encode((usr + ":" + pss).getBytes()));
    }

    public static Response getToken() {
        String authorization = encode(client_id, client_secret);

        return
        given()
                .with()
                .contentType(ContentType.URLENC)
                .header("Authorization", "Basic " + authorization)
                .body("grant_type=client_credentials")
                .post("https://accounts.spotify.com/api/token")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
    public static String parseToken(Response response) {
        token = response.jsonPath().getString("access_token");
        return token;
    }

    @Test
    public void shouldGetToken() {
        Response response = getToken();
        String token = parseToken(response);

        Assertions.assertNotNull(token);
    }

    @Test
    public void shouldMatchNameOfArtist() {
        Response response = getToken();
        String token = parseToken(response);
        given()
                .when()
                .header("Authorization", "Bearer " + token)
                .get("https://api.spotify.com/v1/tracks/6rPO02ozF3bM7NnOV4h6s2")
                .then()
                .statusCode(200)
                .assertThat()
                .body("'album'.artists[0].'name'", equalTo("Luis Fonsi"));
    }

    @Test
    public void shouldMatchNumberOfTracks() {
        Response response = getToken();
        String token = parseToken(response);
        given()
                .when()
                .header("Authorization", "Bearer " + token)
                .get("https://api.spotify.com/v1/tracks?ids=6rPO02ozF3bM7NnOV4h6s2,2TpxZ7JUBn3uw46aR7qd6V")
                .then()
                .statusCode(200)
                .assertThat()
                .body("'tracks'", hasSize(2));
    }
}
