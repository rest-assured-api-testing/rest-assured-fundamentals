//import io.restassured.RestAssured;
//import io.restassured.specification.RequestSpecification;
//import org.apache.http.HttpStatus;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.baseURI;
//
//public class Authentication6Test {
//
//    @Test
//    public void testLogin() {
//        baseURI = "https://api.todoist.com/rest/v1/projects";
//
//        RequestSpecification requestSpecification = RestAssured.given();
//
//        requestSpecification
//                .auth()
//                .oauth2("5703275f22fce7ac417a198be65764263fd0bf6b")
//                .when()
//                .get()
//                .then()
//                .statusCode(HttpStatus.SC_OK);
//    }
//
//}
