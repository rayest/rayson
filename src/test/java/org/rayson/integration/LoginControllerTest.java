package org.rayson.integration;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午4:49
 *  Description:
 **/
public class LoginControllerTest extends TestBase {

    @Test
    public void test() {
        jdbcTemplate.execute("INSERT INTO  rayson_user (id, username, password) " +
                "VALUES (1, 'someone', '123456')");
        System.out.println("heheh");
        assertEquals("someone", jdbcTemplate.queryForObject("SELECT username FROM rayson_user where id = 1", String.class));
    }
}
