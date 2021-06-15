package PaolaAguilar.PaolaMonicaHQ;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class ParameterizationTest {
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

    @DataProvider
    public static Object[][] contactIds() {
        return new Object[][] {
                {"contacts", "531788", "Juancho"},
                {"contacts", "531789", "Naty"},
                {"contacts", "531790", "Juli"}
        };
    }

    @Test
    @UseDataProvider("contactIds")
    public void ContactsNickNameByIdContact(String contactURL, String contactId, String expectedResult) {
        given()
        .auth()
                .oauth2(tokenAuth)
                .pathParam("contactURL", contactURL)
                .pathParam("contactId", contactId)
        .when()
                .get("https://app.monicahq.com/api/{contactURL}/{contactId}")
        .then()
                .assertThat()
                .body("data.'nickname'", equalTo(expectedResult));
    }
}
