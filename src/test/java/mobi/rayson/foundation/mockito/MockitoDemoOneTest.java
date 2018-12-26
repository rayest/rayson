package mobi.rayson.foundation.mockito;

import mobi.rayson.foundation.annotations.Scenario;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-16
 *  Time: 下午6:15
 *  Description:
 **/
public class MockitoDemoOneTest {

    @Scenario("一个对象的具体行为，通过 mock 实现")
    @Test
    public void testDemo1() {
        LinkedList mockedLinkedList = mock(LinkedList.class);

        when(mockedLinkedList.get(0)).thenReturn("100");
        assertEquals("100", mockedLinkedList.get(0));

        when(mockedLinkedList.get(anyInt())).thenReturn("000");
        assertEquals("000", mockedLinkedList.get(12437));

    }

    @Scenario("创建一个对象的 spy，具有该对象的真实行为")
    @Test
    public void testSpy() {
        LinkedList mockedList = spy(LinkedList.class);
        mockedList.add("林黛玉");
        mockedList.add("史湘云");
        assertEquals("林黛玉", mockedList.get(0));
        assertEquals("史湘云", mockedList.get(1));
    }
}
