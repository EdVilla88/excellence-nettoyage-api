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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String comment;
    private int rating;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
