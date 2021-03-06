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
                .auth().oauth2("REPLACE YOUR TOKEN HERE")
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
