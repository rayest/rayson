package org.rayson.api.login;

import org.rayson.api.foundation.exception.BusinessException;
import org.rayson.api.user.User;
import org.rayson.api.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午9:58
 *  Description:
 **/
@Service
public class LoginService {

    @Resource
    private UserRepository userRepository;

    public Identification authenticate(String username, String password) {

        User user = userRepository.getByUsername(username);
        if (null == user) {
            throw new BusinessException("用户不存在");
        }

        if (!user.getPassword().equals(password)) {
            throw new BusinessException("密码错误");
        }
        Identification identification = new Identification();
        identification.setToken("token");
        identification.setUserId("userId");
        return identification;
    }
}
