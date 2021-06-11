package saulcaspa_todoist;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class ProjectsTest {

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;
    private ArrayList<Integer> projectsID = new ArrayList<>();

    @BeforeAll
    public static void setRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/rest/v1")
                .setBasePath("/projects")
                .addHeader("Authorization", "Bearer 44a745758a62dfab98da770ae70c98eb824acc2b")
                .build();
    }

    @BeforeAll
    public static void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }
    @Test
    public void getAllProjectsShouldReturnOk() {
        given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForShouldCreateAProject")
    public void shouldCreateAProject(String name, boolean share, int color, boolean favorite) {

        Project project = new Project();
        project.name(name)
                .favorite(favorite)
                .color(color)
                .shared(share);
        Response response = createProject(project);
        int id = parseID(response);
        Assertions.assertNotNull(id);
    }

    private static Stream<Arguments> provideStringsForShouldCreateAProject() {
        return Stream.of(
                Arguments.of("testProject", false, 46, false),
                Arguments.of("testProject1234", true, 45, true),
                Arguments.of("testProject~!@#$%^&*()", false, 44, true),
                Arguments.of("testProject?|}{[]", true, 43, false)
        );
    }

    private Response createProject(Object bodyData) {
        return given()
                .spec(requestSpecification)
                .contentType("application/json")
                .body(bodyData)
                .when()
                .post()
                .then()
                .log().body()
                .spec(responseSpecification)
                .extract()
                .response();
    }

    private int parseID(Response response) {
        int id = response.jsonPath().getInt("id");
        projectsID.add(id);
        return id;
    }
}
