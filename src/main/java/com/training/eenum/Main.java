package com.training.eenum;

import static com.training.eenum.enums.CalculatorType.CALC_A;
import static com.training.eenum.enums.CalculatorType.CALC_B;
import static com.training.eenum.enums.PayGroup.findByPaymentMethod;
import static com.training.eenum.enums.TableStatus.N;
import static com.training.eenum.enums.TableStatus.Y;

public class Main {
    public static void main(String[] args) {
        // DB 에서 N, Y type 으로 select 후 다른 테이블 값을 바로 get 해서 쓸 수 있음.
        System.out.println(N.getTableAValue() + ", " + N.tableBValue());
        System.out.println(Y.getTableAValue() + ", " + Y.tableBValue());

        System.out.println(CALC_A.calculate(10L));
        System.out.println(CALC_B.calculate(10L));

        String[] paymentMethods = { "포인트", "계좌이체", "신용카드", "용돈" };

        for (String paymentMethod : paymentMethods) {
            System.out.println(findByPaymentMethod(paymentMethod).name());
        }
    }
}
