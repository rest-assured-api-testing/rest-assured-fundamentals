import entities.Project;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Serialization8Test {
    @Test
    public void serialization() {

        Project project = new Project();
        project.setName("API Testing");
        project.setColor(43);

        given()
                .auth().oauth2("3c72b9a42be1313c3f48e58c42d1e0290e475d5b")
                .contentType(ContentType.JSON)
                .body(project)
                .log().body()
                .when()
                .post("https://api.todoist.com/rest/v1/projects")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }
}
