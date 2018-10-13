package org.rayson.foundation.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-16
 *  Time: 下午5:17
 *  Description:
 **/

public class LambdaTest {

    @Test
    public void testForLoop() {
        String[] codes = {"1000", "1001", "1002"};
        List<String> codeList = Arrays.asList(codes);
        codeList.forEach(System.out::println);
        codeList.forEach((code) -> System.out.println("Code is: " + code));
        codeList.forEach(this::toIntAndAddOne);
    }

    private int toIntAndAddOne(String code) {
        return Integer.valueOf(code) + 1;
    }

    @Test
    public void testPredicate() {
        Predicate<String> predicate = (name) -> name.length() > 3;
        assertTrue(predicate.test("Rayest"));
        assertFalse(predicate.negate().test("Rayest"));
    }


}
