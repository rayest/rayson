package mobi.rayson.api.rabbit;

import lombok.Data;
import lombok.experimental.Accessors;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午2:55
 *  Description:
 **/
@Data
@Accessors(chain = true)
public class Product {

    private String id;
    private String name;
    private String price;
    private int stock;
    private String productNo;
    private String productName;
}
