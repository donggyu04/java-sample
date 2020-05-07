package com.training.generic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 배열 공변
        Object[] objectArray = new String[5];
        objectArray[0] = "String";
        //objectArray[1] = 10;

        // generic 불공변
        // List<Object> objectList = new ArrayList<String>();
    }
}
