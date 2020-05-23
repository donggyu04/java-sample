package com.training.algo.baekjoon.kmp;

import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.acmicpc.net/problem/2902
 * */
public class _2902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String userInput = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(userInput, "-");

        while (stringTokenizer.hasMoreTokens()) {
            out.print(stringTokenizer.nextToken().charAt(0));
        }
    }
}
