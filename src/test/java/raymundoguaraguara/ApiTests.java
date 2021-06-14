package raymundoguaraguara;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {
    @Test
    public void checkStatusOnSearchByCocktailNameMargarita() {
        given()
                .when()
                .get("http://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void checkGetLogOnSearchByCocktailNameMargarita() {
        given()
                .log().all()
                .when()
                .get("http://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007")
                .then()
                .log().body();
    }

    @Test
    public void checkEqualstoOnSearchByCocktailNameMargarita() {
        given()
                .when()
                .get("http://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007")
                .then()
                .assertThat()
                .body("drinks[0].'strDrink'", equalTo("Margarita"));
    }
}
