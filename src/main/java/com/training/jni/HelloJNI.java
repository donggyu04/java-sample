package com.training.jni;

public class HelloJNI {

    static {
        System.loadLibrary("printHello");
    }

    public native void printHello();

    public static void main(String[] args) {
        new HelloJNI().printHello();
    }
}
