package org.rayson.api;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;
import org.rayson.foundation.annotations.Scenario;

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

    @Scenario("登录成功")
    @Test
    public void login_loginSuccessfully() {
        jdbcTemplate.execute("INSERT INTO  rayson_user (id, username, password) VALUES (1, 'someone', '123456')");
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

    @Scenario("密码错误")
    @Test
    public void login_shouldLoginFailedIfPasswordIsIncorrect() {
        jdbcTemplate.execute("insert into rayson_user (id, username, password) values (1, 'someone', '123456')");
        given().param("username", "someone")
                .param("password", "wrongPassword")
                .contentType(ContentType.JSON)
                .when()
                .get("/login")
                .then()
                .statusCode(400)
                .body("code", equalTo(400))
                .body("message", equalTo("密码错误"));
    }

    @Scenario("用户不存在")
    @Test
    public void login_shouldLoginFailedIfUsernameIsNotExisted() {
        jdbcTemplate.execute("insert into rayson_user (id, username, password) values (1, 'someone', '123456');");
        given().param("username", "identity")
                .param("password", "123456")
                .contentType(ContentType.JSON)
                .when()
                .get("/login")
                .then()
                .statusCode(400)
                .body("code", equalTo(400))
                .body("message", equalTo("用户不存在"));

    }
}
