package org.rayson.user;

import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午6:21
 *  Description:
 **/
@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
}
