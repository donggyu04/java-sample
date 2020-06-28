package com.training.jython;

import java.util.Map;

public class HttpRequest {

    public static void staticPrintHello() {
        System.out.println("static print hello");
    }

    public void normalPrintHello() {
        System.out.println("normal print hello");
    }

    public static void POST(byte[] params) {
        System.out.println("Byte[] API is called");
    }

//    public static void POST(String params) {
//        System.out.println("String API is called");
//    }

    public static void POST(Map<?, ?> params) {
        System.out.println("Map API is called, params : " + params);
    }

}
