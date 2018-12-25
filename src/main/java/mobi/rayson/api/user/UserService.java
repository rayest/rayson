package mobi.rayson.api.user;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午6:18
 *  Description:
 **/
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getById(Integer id) {
        return userRepository.getById(id);

    }
}
