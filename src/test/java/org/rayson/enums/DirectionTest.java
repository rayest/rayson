package org.rayson.enums;

import org.junit.Test;

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
        DirectionAquirement directionAquirement = new DirectionAquirement();
        String message = directionAquirement.getMessage("1");
        assertEquals("东", message);
    }
}
