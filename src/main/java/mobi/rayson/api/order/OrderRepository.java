package mobi.rayson.api.order;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Repository;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午6:19
 *  Description:
 **/
@Repository
public interface OrderRepository {
    void save(Order order);

    Order selectByOrderNo(String orderNo);

    void batchSave(@Param("membershipNo") String membershipNo, @Param("userNo") String userNo, @Param("level") int level);
}
