package org.rayson.rabbit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午2:53
 *  Description:
 **/
@Component
public class ProductMessageListener {

    @Resource
    private ProductRepository productRepository;

    private static final Logger logger = LogManager.getLogger(ProductMessageListener.class);

    public void receiveMessage(Map<String, ProductDTO> map) {
        logger.info("Message processing...");
        Product product = new Product();
        BeanUtils.copyProperties(map.get("productDTO"), product);
        productRepository.save(product);
        logger.info("Message processed...");
    }
}
