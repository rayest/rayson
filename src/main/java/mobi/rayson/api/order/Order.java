package mobi.rayson.api.order;

import lombok.Data;
import lombok.experimental.Accessors;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午6:21
 *  Description:
 **/
@Data
@Accessors(chain = true)
public class Order {
    private Integer id;
    private String orderNo;
    private String productNo;
    private String userNo;
}
