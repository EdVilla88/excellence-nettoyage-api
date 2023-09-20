package com.villacamp.hn.excellence.dto;

import com.villacamp.hn.excellence.utils.enums.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingDTO {
    private Long id;
    private AddressDTO address;
    private JobDTO job;
    private LocalDateTime bookedDateTime;
    private int locationSize;
    private int rooms;
    private String phone;
    private BookingStatus status;
    private LocalDateTime completionDate;
}
