package com.training.algo;

import com.training.algo.parser.StringParser;
import org.junit.Assert;
import org.junit.Test;

public class StringParserTest {

    @Test
    public void testStringParser() {
        StringParser stringParser = new StringParser();
        String[] input = { "2[ab]", "2[ab]3[bc]", "2[ab3[bc]]", "2[ab3[bc]2d]" };
        String[] expected = { "abab", "ababbcbcbc", "abbcbcbcabbcbcbc", "abbcbcbcddabbcbcbcdd" };

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(expected[i], stringParser.parse(input[i]));
        }
    }

}
