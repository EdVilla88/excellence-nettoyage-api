package com.villacamp.hn.excellence.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {
    private String message;
    private LocalDateTime timeStamp;
    private String path;
}