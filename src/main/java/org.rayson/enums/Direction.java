package org.rayson.enums;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-11
 *  Time: 下午4:37
 *  Description:
 **/
public enum Direction {
    EAST("1", "东"),
    SOUTH("2", "南"),
    WEST("3", "西"),
    NORTH("4", "北"),
    CENTER("5", "中"),;

    private String code;
    private String message;

    Direction(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}

