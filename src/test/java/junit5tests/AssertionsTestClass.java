package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTestClass {

    /**
     * For basic JUnit assertions, we can pass 3 parameters. First one is the expected value, second one is the
     * actual value and the third one is a message to be displayed in case of test failure.
     */
    @Test
    public void assertEqualsTest() {
        assertEquals("firstString", "secondString", "The String values were not equal");
    }

    @Test
    public void assertEqualsListTest() {
        List<String> expecteValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdString");

        assertEquals(expecteValues, actualValues, "Lists are not equal");
        assertNotEquals(expecteValues, actualValues);
    }

    @Test
    public void assertArraysEqualsTest() {
        int[] expectedValues = {1, 5, 3};
        int[] actualValues = {1, 2, 3};

        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    public void assertTrueTest() {
        assertFalse(false);
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    public void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    public void assertAllTest() {
        assertAll(
                () -> assertEquals("firstString", "secondString", "The String values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true")
        );
    }

    @Test
    public void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, Matchers.hasValue(22));
        assertThat(theMap, Matchers.hasKey("secondKey1"));
    }

    @Test
    public void assertForList(){
        List<String> theList = Arrays.asList("firsString", "secondString", "thirdString");

        assertThat(theList, Matchers.hasItem("thirdStrings"));
    }

    @Test
    public void assertForAnyOf(){
        List<String> theList = Arrays.asList("firsString", "secondString", "thirdString");

        assertThat(theList, Matchers.anyOf(Matchers.hasItem("thirdString"), Matchers.hasItem("noString")));
    }

    @Test
    public void assertForContainsAnyOrder(){
        List<String> theList = Arrays.asList("firsString", "secondString", "thirdString");

        assertThat(theList, containsInAnyOrder("firsString", "thirdString", "secondString"));
    }
}
