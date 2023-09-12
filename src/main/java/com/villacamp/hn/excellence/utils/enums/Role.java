package com.villacamp.hn.excellence.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("User"),
    ADMIN("Administrator");

    private final String value;
}
