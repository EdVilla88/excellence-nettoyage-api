package com.villacamp.hn.excellence.entity;

import com.villacamp.hn.excellence.utils.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Address address;
    @OneToOne
    private Job job;
    private LocalDateTime bookedDateTime;
    private int locationSize;
    private int rooms;
    private String phone;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    private LocalDateTime completionDate;
    private LocalDateTime created = LocalDateTime.now();
}