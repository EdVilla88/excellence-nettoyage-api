package com.villacamp.hn.excellence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String latitude;
    private String longitude;
    private String phoneNumber;
}
