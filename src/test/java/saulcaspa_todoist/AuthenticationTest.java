package saulcaspa_todoist;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */

public class AuthenticationTest {

    private RequestSpecification requestSpecification;
    @BeforeAll
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.todoist.com/rest/v1")
                .setBasePath("/projects")
                .build();
    }
    @Test
    public void testLogin() {

        given()
                .spec(requestSpecification)
                .auth()
                .oauth2("44a745758a62dfab98da770ae70c98eb824acc2b")
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
