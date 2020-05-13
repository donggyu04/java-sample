package com.training.finalize;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FinalizableTest {
    @Test
    public void whenGC_thenFinalizerExecuted() throws IOException {
        String firstLine = new Finalizable().readFirstLine();
        assertEquals("가나다라마바사아자차카타파하", firstLine);
        System.gc();
    }

    @Test
    public void non_finalizer() throws IOException {
        try (NonFinalize nonFinalize = new NonFinalize()) {
            String firstLine = nonFinalize.readFirstLine();
            assertEquals("가나다라마바사아자차카타파하", firstLine);
        }
    }
}
