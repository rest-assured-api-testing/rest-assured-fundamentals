package PaolaAguilar.PaolaMonicaHQ;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ResponseExtraction {
    private static String tokenAuth = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyIiwianRpIjoiN2UyZGRlNzk5ZTkyNDMwNGNkY" +
            "TMwYmI3ODczMTM4MmZjZDYwOWIzNjY4YzU2ZGI0NjkzOTg5NjI2ZDcwZjg1ZWNjMmQ3ZjBiOWYzYmZkOWEiLCJpYXQiOjE2MjMzNTkzMT" +
            "guNDQ3Nzg5LCJuYmYiOjE2MjMzNTkzMTguNDQ3Nzk1LCJleHAiOjE2NTQ4OTUzMTguNDM2NjU4LCJzdWIiOiIyNzc5OCIsInNjb3BlcyI" +
            "6W119.PbVrPS0AVIbR5AwmKtVWvSp1_OoiJkZPInCdOneY0OIEeisgrJAHw_5MkyJgm-oDWgkjhVPTys9nYjUg28HLd6gWW6CoVPKnBEZ" +
            "hT5IFJvi9pUY0F-DeIsZ2rRhdjMD_m5LQ8F6l5LycRyYuxfmSi8JLi7ohEJjldi_iwHOiCeDLBossdf6ZJTP0kpcNG4a0HHE_xheUYWP4" +
            "ZVthvoYAHqIyKjYBpqP7xzUSoBqCe-pIrQvjpriV4lfqxh7EmVEGbn0DQw0uq0dQy9uLC2spCiHUORVHoKLVZNH2hwMD_e2z6Ny8u-Us0" +
            "AYg7_2fvDw4R58mqrcG6GbJHqyi9oJ2_70F9B7XLYxB3OMqAdGHt0QaYdByfpByHpZmX16fYvtNwZsr70U2WcfADia6ofwuiZe8Ywd-cz" +
            "NalPh6xUrbrC3iEEnIgC8azcpc57UZGkgl5ZOv4fLXyQGsf7gGMIkIYcYQG5v790J1oDR4_rBIbvBeXaNEvP9dU_TKVd5XcdR-COvShin" +
            "6F4NZIhZE_WfSa7Pz-D1GUyePu64dxBpXEE-HjGyCggVW0AKW6PtnVnF-kd3eFVRKi5iPawL-2pmnMBcvdsKk727oBCwzBxkdy_Av1sFW" +
            "tgyy_d3k3Q8uSECzTRTJ5pRZnyA5OfVaOZi6gV6JR6s7nzGs6T4FjDlv1KM";
    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://app.monicahq.com/api/")
                .build();
    }

    @Test
    public void test2() {
        String nickName = given()
                .spec(requestSpec)
                .auth()
                .oauth2(tokenAuth)
                .when()
                .get("contacts/531788")
                .then()
                .log().all()
                .extract()
                .path("data.'nickname'");

        Assert.assertEquals(nickName, "Juancho");

    }
}
