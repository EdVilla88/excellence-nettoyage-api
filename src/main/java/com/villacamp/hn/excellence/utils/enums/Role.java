package com.villacamp.hn.excellence.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    CLI("Client"),
    EMP("Employee"),
    ADM("Administrator");

    private final String value;
}
