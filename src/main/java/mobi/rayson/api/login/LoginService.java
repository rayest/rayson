package mobi.rayson.api.login;


import mobi.rayson.api.foundation.exception.BusinessException;
import mobi.rayson.api.user.User;
import mobi.rayson.api.user.UserRepository;
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
            throw new BusinessException(LoginCodes.USER_IS_NOT_EXISTED);
        }

        if (!user.getPassword().equals(password)) {
            throw new BusinessException(LoginCodes.USER_OR_PASSWORD_INCORRECT);
        }
        Identification identification = new Identification();
        identification.setToken("token");
        identification.setUserId("userId");
        return identification;
    }
}
