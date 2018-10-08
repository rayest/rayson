package org.rayson.integration.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午4:04
 *  Description:
 **/
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        Authentication authentication = loginService.authenticate(loginDTO);
        return ResponseEntity.ok(authentication);
    }
}
