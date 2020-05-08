package com.training.eenum.enums;

import lombok.Getter;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.EMPTY_LIST;

public enum PayGroup {
    CACHE("현금", asList("계좌이체", "토스")),
    CARD("카드", asList("페이코", "카카오 페이", "신용카드")),
    ETC("기타", asList("포인트", "쿠폰")),
    EMPTY("없음", EMPTY_LIST);

    @Getter
    private String title;
    // paymentMethod 들을 String 에서 Enum 으로 변경하여 좀 더 type safe 하게 만들 수 있다.
    private List<String> paymentMethods;

    PayGroup(String title, List<String> paymentMethods) {
        this.title = title;
        this.paymentMethods = paymentMethods;
    }

    public static PayGroup findByPaymentMethod(String paymentMethod) {
        return stream(PayGroup.values())
                .filter(payGroup -> payGroup.hasPaymentMethod(paymentMethod))
                .findAny()
                .orElse(EMPTY);
    }

    private boolean hasPaymentMethod(String paymentMethodCode) {
        return paymentMethods
                .stream()
                .anyMatch(paymentMethod -> paymentMethod.equals(paymentMethodCode));
    }
}
