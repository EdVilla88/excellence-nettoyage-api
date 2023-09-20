package com.villacamp.hn.excellence.entity;

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
    private LocalDateTime dateTime;
    private int locationSize;
    private int rooms;
    private String phone;
}