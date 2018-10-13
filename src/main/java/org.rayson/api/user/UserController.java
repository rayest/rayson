package org.rayson.api.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午2:47
 *  Description:
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }
}
