package mobi.rayson.foundation.tools;

import mobi.rayson.foundation.common.LombokDemo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-09
 *  Time: 下午4:03
 *  Description:
 **/
public class LombokDemoTest {

    @Test
    public void testBuilder() {
        LombokDemo demo = LombokDemo
                .builder()
                .id(1)
                .description("这是描述")
                .name("demo")
                .build();
        assertEquals("这是描述", demo.getDescription());
        assertEquals("demo", demo.getName());
    }
}
