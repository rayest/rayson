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

    public Demo(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
