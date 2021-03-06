package mobi.rayson.foundation.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import mobi.rayson.foundation.common.Demo;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-31
 *  Time: 下午3:46
 *  Description:
 **/
public class StreamTest {
    private final int initValue = 5;

    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(2, 4, 6);

        int reduceResult = list.stream().reduce(initValue, (x, y) -> x * y);

        int forResult = initValue;
        for (Integer integer : list) {
            forResult *= integer;
        }
        assertEquals("Both result are 240", reduceResult, forResult);

    }

    @Test
    public void testForEach() {
        Demo demoRay = Demo.builder().withId(UUID.randomUUID().toString()).build();
        Demo demoRayest = Demo.builder().withId(UUID.randomUUID().toString()).build();
        List<Demo> demoList = Arrays.asList(demoRay, demoRayest);

        assertThat(demoList.get(0).getId(), containsString("-"));

        demoList.forEach(this::changeDemo);

        assertThat(demoList.get(0).getId(), not(containsString("-")));

    }

    private void changeDemo(Demo demo) {
        String id = demo.getId();
        demo.setId(id.replace("-", ""));
    }

    @Test
    public void testFilter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        assertEquals(5, filtered.size());
    }

    @Test
    public void testMap() {
        List<String> origin = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> upper = origin.stream().map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(7, upper.size());
        assertEquals("ABC", upper.get(0));
    }

}
