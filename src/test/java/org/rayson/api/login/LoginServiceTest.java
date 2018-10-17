package org.rayson.api.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.rayson.api.foundation.exception.BusinessException;
import org.rayson.api.user.UserRepository;

import static org.mockito.Mockito.when;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-17
 *  Time: 上午10:54
 *  Description:
 **/
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @InjectMocks
    private LoginService loginService;

    @Mock
    private UserRepository userRepository;

    @Test(expected = BusinessException.class)
    public void test_username_is_not_exist() {
        String noneExistUsername = "none-exist-username";
        String password = "123456";
        when(userRepository.getByUsername(noneExistUsername)).thenReturn(null);
        loginService.authenticate(noneExistUsername, password);
    }
}
