package mobi.rayson.api.login;

import mobi.rayson.api.foundation.exception.BusinessException;
import mobi.rayson.api.user.User;
import mobi.rayson.api.user.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
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

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throws_BusinessException_for_username_is_not_exist() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage(LoginCodes.USER_IS_NOT_EXISTED.message());

        String noneExistUsername = "none-exist-username";
        String password = "123456";
        when(userRepository.getByUsername(noneExistUsername)).thenReturn(null);

        loginService.authenticate(noneExistUsername, password);
    }

    @Test
    public void throws_BusinessException_for_password_or_username_incorrect() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage(LoginCodes.USER_OR_PASSWORD_INCORRECT.message());

        String username = "someone";
        String password = "password";
        User expectedUser = new User();
        expectedUser.setUsername(username);
        expectedUser.setPassword(password);

        when(userRepository.getByUsername(username)).thenReturn(expectedUser);

        String incorrectPassword = "incorrectPassword";
        loginService.authenticate(username, incorrectPassword);
    }

    @Test
    public void login_successfully() {
        String username = "someone";
        String password = "password";
        User expectedUser = new User();
        expectedUser.setUsername(username);
        expectedUser.setPassword(password);

        when(userRepository.getByUsername(username)).thenReturn(expectedUser);

        Identification identification = loginService.authenticate(username, password);
        assertEquals("token", identification.getToken());
        assertEquals("userId", identification.getUserId());
    }
}
