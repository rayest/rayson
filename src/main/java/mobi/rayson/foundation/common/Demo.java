package mobi.rayson.foundation.common;

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

    public static DemoBuilder builder(){
        return new DemoBuilder();
    }
}
