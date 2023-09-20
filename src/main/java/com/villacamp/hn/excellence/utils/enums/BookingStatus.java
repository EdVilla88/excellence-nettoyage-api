package com.villacamp.hn.excellence.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookingStatus {
    PND("Pending"),
    WIP("Work in progress"),
    COM("Completed");

    private final String value;
}