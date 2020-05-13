package com.training.finalize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.Objects.requireNonNull;

public class NonFinalize implements AutoCloseable {
    private BufferedReader bufferedReader;

    public NonFinalize() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sample.txt");
        this.bufferedReader = new BufferedReader(new InputStreamReader(requireNonNull(inputStream)));
    }

    public String readFirstLine() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
            System.out.println("Closed BufferedReader in the close");
        } catch (IOException e) {
            // NoOp
        }
    }
}
