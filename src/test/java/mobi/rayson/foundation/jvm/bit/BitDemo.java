package mobi.rayson.foundation.jvm.bit;

import org.junit.Test;
import org.rayson.foundation.annotations.Scenario;

import static org.junit.Assert.assertEquals;

public class BitDemo {

    @Scenario("左位移运算，5(0000 0101) 向左移动三位为 0010 1000，即为 40。或 5*2^3")
    @Test
    public void testLeftShift() {
        assertEquals(40, 5 << 3);
    }

    @Scenario("右位移运算，10(0000 1010) 向右移动两位为 0000 0010，即为 2。或 10/2^2")
    @Test
    public void testRightShift() {
        assertEquals(2, 10 >> 2);
    }


}
