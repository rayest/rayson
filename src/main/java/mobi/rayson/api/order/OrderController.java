package mobi.rayson.api.order;

import mobi.rayson.api.rabbit.Product;
import mobi.rayson.api.rabbit.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午2:47
 *  Description:
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping(value = "/order")
    public void buy(@RequestBody Order order) throws Exception {
        orderService.save(order);
    }

    @PostMapping(value = "/batch")
    public void batchSave() {
        orderService.batchSave();
    }


}
