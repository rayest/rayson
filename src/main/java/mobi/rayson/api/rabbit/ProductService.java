package mobi.rayson.api.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static mobi.rayson.api.rabbit.RabbitMQConfiguration.TEST_RABBIT_USER_QUEUE;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午3:08
 *  Description:
 **/
@Service
public class ProductService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ResponseEntity create(ProductDTO productDTO) {
        Map<String, ProductDTO> map = new HashMap<>();
        map.put("productDTO", productDTO);
        logger.info("Sending message to queue...");
        rabbitTemplate.convertAndSend(TEST_RABBIT_USER_QUEUE, map);
        return ResponseEntity.ok().build();
    }

    @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public void save(String productNo) throws Exception {
        Product product = new Product().setProductNo(productNo);
        productRepository.deduct(product);
        if (true){
            throw new Exception("回滚");
        }
    }
}
