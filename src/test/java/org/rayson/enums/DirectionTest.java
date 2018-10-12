package org.rayson.enums;

import org.junit.Test;
import org.rayson.enums.DirectionAcquirement;

import static org.junit.Assert.assertEquals;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-11
 *  Time: 下午4:42
 *  Description:
 **/
public class DirectionTest {

    @Test
    public void test() {
        DirectionAcquirement directionAcquirement = new DirectionAcquirement();
        String message = directionAcquirement.getMessage("1");
        assertEquals("东", message);
    }
}
