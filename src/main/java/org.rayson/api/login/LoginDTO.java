package org.rayson.api.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午9:57
 *  Description:
 **/
@Data
public class LoginDTO {

    @NotBlank(message = "用户名不可为空")
    private String username;

    @NotBlank(message = "密码不可为空")
    private String password;
}
