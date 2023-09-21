package com.villacamp.hn.excellence.dto;

import com.villacamp.hn.excellence.utils.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
