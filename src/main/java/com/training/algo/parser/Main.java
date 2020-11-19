package com.training.algo.parser;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    private static final Scanner scanner = new Scanner(in);

    public static void main(String[] args) {
        out.print("Input: ");
        String userInput = scanner.next();
        out.println(new StringParser().parse(userInput));
    }

}
