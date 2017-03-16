package net.agnul;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class KataKalkTest {

    KataKalk kalk = new KataKalk();

    @Test
    public void testOnEmptyString() {
        assertThat(kalk.add(""), is(0));
    }

    @Test
    public void testASingleNumber() {
        assertThat(kalk.add("42"), is(42));
    }

    @Test
    public void testTwoNumbers() {

        assertThat(kalk.add("40,2"), is(42));

    }

    @Test
    public void testThreeNumbers() {

        assertThat(kalk.add("20,20,2"), is (42));

    }

    @Test
    public void testManyNumbers() {

        assertThat(kalk.add("20,10,5,5,2"), is (42));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testManyNumbersAndNegatives() {

        assertThat(kalk.add("20,30,-5,-5,2"), is (42));

    }

    @Test
    public void testWithRandomSpacesBetweenNumbers() {

        assertThat(kalk.add("20, 10,5     ,     5,2"), is (42));

    }

    @Test
    public void testWithNewLines() {

        assertThat(kalk.add("20\n, 10,5\n          5,\n\n2"), is (42));

    }

    @Test
    public void testWithCustomDelimiters() {

        assertThat(kalk.add("//#\n20#, 10,5\n          5,#\n2"), is (42));

    }
}
