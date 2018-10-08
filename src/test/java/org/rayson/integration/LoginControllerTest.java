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
        jdbcTemplate.execute("INSERT INTO  kb_user_registration (id,email,user_name,password,salt) " +
                "VALUES ('fooUserId','someone@gmail.com','someone','148412d9df986f739038ad22c77459f2','fooId')");
        System.out.println("heheh");
        assertEquals("fooUserId", jdbcTemplate.queryForObject("SELECT id FROM kb_user_registration where user_name='someone'", String.class));
    }
}
