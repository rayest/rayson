package mobi.rayson.foundation.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.rayson.api.user.User;
import org.rayson.api.user.UserRepository;
import org.rayson.api.user.UserService;
import org.rayson.foundation.annotations.Scenario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-16
 *  Time: 下午10:09
 *  Description:
 **/
@RunWith(MockitoJUnitRunner.class)
public class MockitoUserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Scenario("被 @Mock 或者 @Spy 注解修饰的实例，将会被注入到被 @InjectMocks 修饰的类中")
    @Test
    public void testGetById() {
        User user = new User();
        user.setId(1);
        user.setUsername("王熙凤");
        when(userRepository.getById(1)).thenReturn(user);
        assertEquals("王熙凤", userService.getById(1).getUsername());
    }
}
