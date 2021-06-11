package CristianChoqueTodoist;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import com.tngtech.java.junit.dataprovider.DataProvider;
//import com.tngtech.java.junit.dataprovider.DataProviderRunner;
//import com.tngtech.java.junit.dataprovider.UseDataProvider;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//@RunWith(DataProviderRunner.class)
public class ParameterizationTodoistTest {
//    @DataProvider
//    public static Object[][] testProvider() {
//        return new Object[][]{
//                {"2267202896", "Prueba los Paneles"},
//                {"2267234459", "shopping list 1"},
//                {"2267234543", "shopping list 2 updated"},
//                {"2267325020", "project created from java"}
//        };
//    }

//    @Test
//    @UseDataProvider("testProvider")
//    public void test1(String id, String expectedResult) {
//        given()
//                .header("Content-type", "application/json")
//                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
//                .pathParam("id", id)
//                .when()
//                .get("https://api.todoist.com/rest/v1/projects/{id}")
//                .then()
//                .assertThat()
//                .body("name", equalTo(expectedResult));
//    }
}