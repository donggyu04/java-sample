package com.training.algo.parser;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.isNumeric;

public class StringParser {

    public String parse(String userInput) {
        Stack<String> stack = new Stack<>();
        String[] userInputTokens = userInput.split("");

        for (String token : userInputTokens) {
            if (StringUtils.equals(token, "]")) {
                String parsedStr = parseInBrackets(stack);
                stack.push(parsedStr);
                continue;
            }

            if (isPreviousCharNumeric(stack) && !StringUtils.equals(token, "[")) {
                int multiplyOperand = parseInt(stack.pop());
                token = token.repeat(multiplyOperand);
            }

            stack.push(token);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    private boolean isPreviousCharNumeric(Stack<String> stack) {
        if (stack.empty()) {
            return false;
        }
        return isNumeric(stack.peek());
    }

    @SuppressWarnings("ConditionalBreakInInfiniteLoop")
    private String parseInBrackets(Stack<String> charStack) {
        StringBuilder result = new StringBuilder();
        String currentToken = charStack.pop();

        while (true) {
            if (StringUtils.equals(currentToken, "[")) {
                break;
            }
            result.insert(0, currentToken);
            currentToken = charStack.pop();
        }

        int multiplyOperand = parseInt(charStack.pop());
        return result.toString().repeat(multiplyOperand);
    }
}
