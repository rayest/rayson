package mobi.rayson.foundation.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.rayson.foundation.annotations.Scenario;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-16
 *  Time: 下午9:45
 *  Description:
 **/
@RunWith(MockitoJUnitRunner.class)
public class MockitoDemoTwoTest {

    @Mock
    private ArrayList mockedArrayList;

    @Spy
    private LinkedList mockedLinkedList;

    @Scenario("@Spy 注解实现同样的功能")
    @Test
    public void testSpy() {
        mockedLinkedList.add("薛宝钗");
        mockedLinkedList.add("贾宝玉");
        assertEquals("薛宝钗", mockedLinkedList.get(0));
        assertEquals("贾宝玉", mockedLinkedList.get(1));
    }

    @Scenario("@Mock 注解实现同样的功能")
    @Test
    public void testMock() {
        when(mockedArrayList.get(0)).thenReturn("香菱");
        assertEquals("香菱", mockedArrayList.get(0));
    }
}
