package com.training.knowledge.in;

import static java.lang.Integer.toBinaryString;
import static java.lang.System.out;

public class BitCalculation {

    public static void main(String[] args) {
        // ... 00001010
        int num = 10;
        out.println(toBinaryString(num));
        out.println(toBinaryString(num * -1));

        // ... 11110101
        out.println(~num);
        out.println(toBinaryString(~num));

        out.println(~(11) + 1);
        out.println(~(-11) + 1);

        // 비트의 1의 보수 값에 + 1을 해줘야 원 값이 반대 부호 값이 됨.
        // 음의 2진수 값 절대 값은 해당 비트 셋의 2의 보수값임.
    }
}
