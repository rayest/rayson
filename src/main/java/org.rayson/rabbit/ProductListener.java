package org.rayson.rabbit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

import static org.rayson.rabbit.RabbitMQConfiguration.TEST_RABBIT_USER_QUEUE;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午2:53
 *  Description:
 **/
@Component
@RabbitListener(queues = TEST_RABBIT_USER_QUEUE)
public class ProductListener {

    @Resource
    private ProductRepository productRepository;

    private static final Logger logger = LogManager.getLogger(ProductListener.class);

    @RabbitHandler
    public void receive(Map<String, ProductDTO> map) {
        logger.info("Message processing...");
        Product product = new Product();
        BeanUtils.copyProperties(map.get("productDTO"), product);
        productRepository.save(product);
        logger.info("Message processed...");
    }
}
