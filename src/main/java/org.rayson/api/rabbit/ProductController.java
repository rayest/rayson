package org.rayson.api.rabbit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午3:06
 *  Description:
 **/
@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/rabbit/product")
    public ResponseEntity create(@RequestBody ProductDTO productDTO){
        return productService.create(productDTO);
    }
}
