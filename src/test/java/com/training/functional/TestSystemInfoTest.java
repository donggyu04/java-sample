package com.training.functional;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSystemInfoTest {

    @Test
    public void testFunctionalInterface() {
        Function<Integer, String> intToString = num -> num.toString() + "first";
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        assertEquals("'5first'", quoteIntToString.apply(5));
    }

    @Test
    public void testShortToByteFunction() {
        Main main = new Main();
        short[] array = {1, 2, 3};
        byte[] transformedArray = main.transformArray(array, s -> (byte) (s * 2));

        byte[] expectedArray = {2, 4, 6};
        assertArrayEquals(expectedArray, transformedArray);
    }
}
