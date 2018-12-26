package mobi.rayson.api.user;

import com.jayway.restassured.http.ContentType;
import mobi.rayson.api.TestBase;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-17
 *  Time: 上午10:36
 *  Description:
 **/
public class UserControllerTest extends TestBase {

    @Test
    public void user_should_return_user_if_id_exists() {
        jdbcTemplate.execute("insert into rayson_user (id, username, password) values (1, 'someone', '123456')");
        given().pathParam("id", 1)
                .contentType(ContentType.JSON)
                .when()
                .get("/user/id/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("someone"));
    }
}
