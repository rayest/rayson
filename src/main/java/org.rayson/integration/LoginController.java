package org.rayson.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午4:04
 *  Description:
 **/
@RestController
public class LoginController {

    @GetMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.ok("login ok");
    }
}
