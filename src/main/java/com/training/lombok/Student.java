
package com.training.lombok;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //    @NonNull
    @Builder.Default
    private String name = "lombok";

    @Builder.Default
    private String address = "korea";

    @Builder.Default
    private List<String> favorites = new ArrayList<>();

    @Getter(lazy = true)
    private final String lazyValue = initLazyValue();

    static int initLazyValueCallCount = 0;

//    static {
//        initLazyValueCallCount++;
//    }

    String initLazyValue() {
        initLazyValueCallCount++;
        return "lazy";
    }

}
