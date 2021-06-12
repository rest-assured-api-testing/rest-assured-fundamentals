import entities.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeSerialization7Test {

    @Test
    public void deserialization() {
        Location location = given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .as(Location.class);

        Assert.assertEquals(location.getPlaces().get(0).getPlaceName(), "Beverly Hills");
    }
}
