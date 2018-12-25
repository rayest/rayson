package mobi.rayson.api.login;

import mobi.rayson.api.foundation.application.DomainOrder;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-13
 *  Time: 下午10:36
 *  Description:
 **/
public enum LoginCodes {
    USER_IS_NOT_EXISTED("001", "用户不存在，请先注册。"),
    USER_OR_PASSWORD_INCORRECT("002", "用户名或者密码错误。"),;

    private String code;
    private String message;

    LoginCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return Integer.parseInt(DomainOrder.LOGIN + code);
    }

    public String message() {
        return message;
    }
}
