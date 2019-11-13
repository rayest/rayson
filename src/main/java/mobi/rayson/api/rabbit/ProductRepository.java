package mobi.rayson.api.rabbit;

import java.util.Optional;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午2:55
 *  Description:
 **/
public interface ProductRepository {
    Optional<Product> findById(Long id);

    void save(Product product);

    void deduct(Product product);
}
