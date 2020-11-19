package com.training.algo.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Arrays.asList;

public class Regex {

    private static final String MULTI_MATCHER = "*";
    private static final String SINGLE_MATCHER = "?";

    @SuppressWarnings({"ConditionalBreakInInfiniteLoop", "ConstantConditions"})
    public boolean match(String regex, String str) {
        Queue<String> regexQueue = new LinkedList<>(asList(regex.split("")));
        Queue<String> strQueue = new LinkedList<>(asList(str.split("")));

        while (!regexQueue.isEmpty()) {
            String regexToken = regexQueue.poll();

            if (isMatcher(regexToken)) {
                if (StringUtils.equals(regexToken, SINGLE_MATCHER)) {
                    strQueue.poll();
                } else {
                    if (regexQueue.isEmpty()) {
                        return true;
                    }
                    String nextToken = regexQueue.peek();
                    while (true) {
                        if (strQueue.peek().equals(nextToken)) {
                            break;
                        }
                        strQueue.poll();
                    }
                }
                continue;
            }

            if (StringUtils.equals(regexToken, strQueue.poll())) {
                continue;
            }
            return false;
        }

        return strQueue.isEmpty() || regexQueue.isEmpty();
    }

    private boolean isMatcher(String token) {
        return StringUtils.equals(token, MULTI_MATCHER) || StringUtils.equals(token, SINGLE_MATCHER);
    }

}
