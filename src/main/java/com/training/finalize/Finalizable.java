package com.training.finalize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.Objects.requireNonNull;

public class Finalizable {
    private BufferedReader bufferedReader;

    public Finalizable() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sample.txt");
        this.bufferedReader = new BufferedReader(new InputStreamReader(requireNonNull(inputStream)));
    }

    public String readFirstLine() throws IOException {
        return bufferedReader.readLine();
    }

    /**
     *
     * finalize() 의 문제점
     * 1. Lack of promptness, 가비지 컬렉터가 언제 든 발생할 수 있으므로 호출 시점을 알 수 없다.
     * 2. GC가 JVM 의존 적이라 프로그램 이식성에 문제가 있을 수 있음. (JVM 구현에 따라 동작이 달라 질 수 있다)
     * 3. finalize 내부에서 exception 발생 시
     *    finalization process is canceled, and the exception is ignored, leaving the object in a corrupted state.
     * */
    @Override
    public void finalize() {
        try {
            bufferedReader.close();
            System.out.println("Closed BufferedReader in the finalizer");
        } catch (IOException e) {
            // NoOp
        }
    }
}
