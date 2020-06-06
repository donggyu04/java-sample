package com.training.threadlocal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Context {
    private final String name;

    @Override
    public boolean equals(Object object) {
        return object instanceof Context && ((Context) object).name.equals(name);
    }
}
