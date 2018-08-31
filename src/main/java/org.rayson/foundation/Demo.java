package org.rayson.foundation;

import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-31
 *  Time: 下午4:34
 *  Description:
 **/
@Data
public class Demo {
    private String id;
    private String name;
    private int age;

    public Demo(String id) {
        this.id = id;
    }

    public Demo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Demo(String id, int age) {
        this.id = id;
        this.age = age;
    }
}
