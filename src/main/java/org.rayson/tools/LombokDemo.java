package org.rayson.tools;

import lombok.Builder;
import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-09
 *  Time: 下午4:01
 *  Description:
 **/
@Data
@Builder
public class LombokDemo {
    private Integer id;
    private String name;
    private String description;
}
