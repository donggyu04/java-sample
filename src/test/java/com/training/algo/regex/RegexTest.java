package com.training.algo.regex;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    @Test
    public void testRegexMatch() {
        Regex regex = new Regex();
        String[] input = { "coding, interview, apple, banana, fruits, Love, Landvibe" };
        String[] regexes = { "*ing", "in*", "app?e", "ba*na", "fru*its", "Love*", "L*d?i*e" };

        for (int i = 0; i < 1; i++) {
            Assert.assertTrue(regex.match(regexes[i], input[i]));
        }
        Assert.assertFalse(regex.match("vanilla", "vani?a"));
    }
}
