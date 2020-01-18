package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class AssertTest {

    @Test
    public void assertTrue() throws Exception {
        Assert.assertTrue("not ok", 2 < 3);
    }

    @Test
    public void assertFalse() {
        Assert.assertFalse("not ok", 7 < 3);
    }

    @Test
    public void assertEqualsTest() throws Exception {
        Integer i = Integer.valueOf("5");
        Integer j = Integer.valueOf("5");
        ;
        assertEquals(i, j);
    }

    @Test
    public void assertNotSameTest() throws Exception {
        Integer i = Integer.valueOf("5");
        Integer j = Integer.valueOf("7");
        assertNotSame(i, j);
    }

    @Test
    public void assertNullTest() throws Exception {
        Object myObject = null;
        Assert.assertNull(myObject);

        myObject = new String("Some value");
        Assert.assertNotNull(myObject);
    }

    @Test
    public void assertNotNullTest() throws Exception {
        Object myObject = null;
        myObject = new String("Some value");
        Assert.assertNotNull(myObject);
    }

    @Test
    public void verify_Matcher() throws Exception {
        int age = 30;
        assertThat(age, equalTo(30));
        assertThat(age, is(30));

        assertThat(age, not(equalTo(33)));
        assertThat(age, is(not(33)));
    }

    @Test
    public void verify_multiple_values() throws Exception {

        double marks = 100.00;
        assertThat(marks, either(is(100.00)).or(is(90.9)));

        assertThat(marks, both(not(99.99)).and(not(60.00)));

        assertThat(marks, anyOf(is(100.00), is(1.00), is(55.00), is(88.00), is(67.8)));

        assertThat(marks, not(anyOf(is(0.00), is(200.00))));

        assertThat(marks, not(allOf(is(1.00), is(100.00), is(30.00))));
    }

    @Test
    public void verify_collection_values() throws Exception {

        List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);

        assertThat(salary, hasItem(50.00));
        assertThat(salary, hasItems(50.00, 200.00));
        assertThat(salary, not(hasItem(1.00)));
    }

    @Test
    public void verify_Strings() throws Exception {
        String name = "John Jr Dale";
        assertThat(name, startsWith("John"));
        assertThat(name, endsWith("Dale"));
        assertThat(name, containsString("Jr"));
    }

}