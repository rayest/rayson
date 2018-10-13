package org.rayson.foundation.lambda.comparator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-27
 *  Time: 下午4:30
 *  Description:
 **/
public class ComparatorTest {

    @Test
    public void testSort() {
        List<String> names = Arrays.asList("Cristina", "Anna", "Brown");
        names.sort(String::compareToIgnoreCase);
        assertEquals("Anna", names.get(0));
        assertEquals("Brown", names.get(1));
        assertEquals("Cristina", names.get(2));
    }

    @Test
    public void testReverseSort() {
        List<String> names = Arrays.asList("Cristina", "Anna", "Brown");
        names.sort(Comparator.reverseOrder());
        assertEquals("Anna", names.get(2));
        assertEquals("Brown", names.get(1));
        assertEquals("Cristina", names.get(0));
    }

    @Test
    public void testNullsFirst() {
        List<String> names = Arrays.asList("Anna", null, "Brown");
        names.sort(Comparator.nullsFirst(String::compareTo));
        assertNull(names.get(0));
    }

    @Test
    public void testNullsLast() {
        List<String> names = Arrays.asList("Anna", null, "Brown");
        names.sort(Comparator.nullsLast(String::compareTo));
        assertNull(names.get(2));
    }

    @Test
    public void testNullable() {
        List<String> names = Arrays.asList("Cristina", "Anna", "Brown");
        Optional.of(names).ifPresent(name -> names.sort(Comparator.naturalOrder()));
        assertEquals("Anna", names.get(0));
    }
}
