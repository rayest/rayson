package mobi.rayson.api.order;

import lombok.extern.slf4j.Slf4j;
import mobi.rayson.api.rabbit.Product;
import mobi.rayson.api.rabbit.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午6:18
 *  Description:
 **/
@Service
@Slf4j
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(Order orderDTO) throws Exception {
        saveOrder(orderDTO);
        if (true) {
            throw new Exception("不回滚");
        }
    }

    private void saveOrder(Order orderDTO) {
        Product product = new Product().setProductNo(orderDTO.getProductNo());
        productRepository.deduct(product);
        Order order = new Order().setOrderNo("123").setProductNo(orderDTO.getProductNo()).setUserNo(orderDTO.getUserNo());
        orderRepository.save(order);
    }

    public void batchSave() {
        for (int i = 0; i < 10000; i++) {
            String membershipNo = UUID.randomUUID().toString();
            String userNo = UUID.randomUUID().toString();
            int level = 1;
            orderRepository.batchSave(membershipNo, userNo, level);
        }
    }
}
