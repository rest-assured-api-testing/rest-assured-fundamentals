package PaolaAguilar.PaolaMonicaHQ;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpec {
    private static ResponseSpecification responseSpec;
    private String tokenAuth = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyIiwianRpIjoiN2UyZGRlNzk5ZTkyNDMwNGNkY" +
            "TMwYmI3ODczMTM4MmZjZDYwOWIzNjY4YzU2ZGI0NjkzOTg5NjI2ZDcwZjg1ZWNjMmQ3ZjBiOWYzYmZkOWEiLCJpYXQiOjE2MjMzNTkzMT" +
            "guNDQ3Nzg5LCJuYmYiOjE2MjMzNTkzMTguNDQ3Nzk1LCJleHAiOjE2NTQ4OTUzMTguNDM2NjU4LCJzdWIiOiIyNzc5OCIsInNjb3BlcyI" +
            "6W119.PbVrPS0AVIbR5AwmKtVWvSp1_OoiJkZPInCdOneY0OIEeisgrJAHw_5MkyJgm-oDWgkjhVPTys9nYjUg28HLd6gWW6CoVPKnBEZ" +
            "hT5IFJvi9pUY0F-DeIsZ2rRhdjMD_m5LQ8F6l5LycRyYuxfmSi8JLi7ohEJjldi_iwHOiCeDLBossdf6ZJTP0kpcNG4a0HHE_xheUYWP4" +
            "ZVthvoYAHqIyKjYBpqP7xzUSoBqCe-pIrQvjpriV4lfqxh7EmVEGbn0DQw0uq0dQy9uLC2spCiHUORVHoKLVZNH2hwMD_e2z6Ny8u-Us0" +
            "AYg7_2fvDw4R58mqrcG6GbJHqyi9oJ2_70F9B7XLYxB3OMqAdGHt0QaYdByfpByHpZmX16fYvtNwZsr70U2WcfADia6ofwuiZe8Ywd-cz" +
            "NalPh6xUrbrC3iEEnIgC8azcpc57UZGkgl5ZOv4fLXyQGsf7gGMIkIYcYQG5v790J1oDR4_rBIbvBeXaNEvP9dU_TKVd5XcdR-COvShin" +
            "6F4NZIhZE_WfSa7Pz-D1GUyePu64dxBpXEE-HjGyCggVW0AKW6PtnVnF-kd3eFVRKi5iPawL-2pmnMBcvdsKk727oBCwzBxkdy_Av1sFW" +
            "tgyy_d3k3Q8uSECzTRTJ5pRZnyA5OfVaOZi6gV6JR6s7nzGs6T4FjDlv1KM";

    @BeforeClass
    public static void createResponse() {
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void ResponseNickNameByIdContact() {
        given()
        .auth()
                .oauth2(tokenAuth)
        .when()
                .get("https://app.monicahq.com/api/contacts/531788")
        .then()
                .spec(responseSpec)
        .assertThat()
                .log().all()
                .body("data.'nickname'", equalTo("Juancho"));
    }
}
