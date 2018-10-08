package org.rayson.integration.login;

import org.rayson.integration.foundation.exception.BusinessException;
import org.rayson.user.User;
import org.rayson.user.UserRepository;
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

    public Authentication authenticate(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        User user = userRepository.getByUsername(username);
        if (null == user) {
            throw new BusinessException("用户名不存在");
        }
        String password = loginDTO.getPassword();
        if (user.getPassword().equals(password)) {
            throw new BusinessException("密码错误");
        }

        return null;
    }
}
