package org.rayson.api.rabbit;

import lombok.Data;

import java.io.Serializable;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午3:33
 *  Description:
 **/
@Data
public class ProductDTO implements Serializable {
    private String name;
    private String price;
}
