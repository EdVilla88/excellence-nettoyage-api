package com.villacamp.hn.excellence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private long id;
    private String title;
    private String description;
    private BigDecimal price;
    private EmployeeDTO employee;
    private List<ReviewDTO> reviews;
}
