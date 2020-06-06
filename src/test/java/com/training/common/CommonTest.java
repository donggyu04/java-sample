package com.training.common;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CommonTest {

    @Test
    public void tryFinalReturnTest() {
        assertEquals(syntaxTest(), 100); // pass
        assertEquals(syntaxTest(), 200); // fail
    }

    private int syntaxTest() {
        try {
            System.out.println("In try block()");
//            throw new RuntimeException("Runtime Exception");
            return 200;
        } catch (Exception ignored) {

        } finally {
            System.out.println("In finally block()");
            return 100;
        }
    }
}
