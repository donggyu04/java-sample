package com.training.eenum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 *
 * Origin table value Y, N these are mapped to "1", "0" and true, false to other tables.
 *
 * */
@Getter
@AllArgsConstructor
public enum TableStatus {
    Y("1", true),
    N("0", false);

    private String tableAValue;
    @Accessors(fluent = true)
    private boolean tableBValue;
}
