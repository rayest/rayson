package mobi.rayson.foundation.jdk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-30
 *  Time: 下午2:45
 *  Description:
 **/
public class JDKTest {

    @Test
    public void test_() {
        long amount = 10_000_000L;
        assertEquals(10000000L, amount);
    }
}
