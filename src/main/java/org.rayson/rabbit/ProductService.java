package org.rayson.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.rayson.rabbit.RabbitMQConfiguration.TEST_RABBIT_USER_QUEUE;

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

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ResponseEntity create(ProductDTO productDTO) {
        Map<String, ProductDTO> map = new HashMap<>();
        map.put("productDTO", productDTO);
        logger.info("Sending message to queue...");
        rabbitTemplate.convertAndSend(TEST_RABBIT_USER_QUEUE, map);
        return ResponseEntity.ok().build();
    }
}
