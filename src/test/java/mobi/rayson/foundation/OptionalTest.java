package mobi.rayson.foundation;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-27
 *  Time: 下午6:31
 *  Description:
 **/
public class OptionalTest {

    @Test
    public void testIsPresent() {
        Optional<String> name = Optional.of("lee");
        assertTrue(name.isPresent());
        assertEquals("lee", name.get());
        name.ifPresent(s -> System.out.println(s));
    }

}
