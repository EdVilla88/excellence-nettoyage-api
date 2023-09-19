package com.villacamp.hn.excellence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "employee_id"}))
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String createdBy;
    private LocalDateTime created = LocalDateTime.now();
    private String updatedBy;
    private LocalDateTime updated;
    @OneToOne
    private User employee;
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
