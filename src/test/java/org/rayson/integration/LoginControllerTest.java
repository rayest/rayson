package org.rayson.integration;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午4:49
 *  Description:
 **/

public class LoginControllerTest extends TestBase{

    @Test
    public void login_loginSuccessfully() {
        jdbcTemplate.execute("INSERT INTO  rayson_user (id, username, password) " +"VALUES (1, 'someone', '123456')");
        given().param("username", "someone")
                .param("password", "123456")
                .contentType(ContentType.JSON)
                .when()
                .get("/login")
                .then()
                .statusCode(200)
                .body("token", equalTo("token"))
                .body("userId", equalTo("userId"));
    }
}
