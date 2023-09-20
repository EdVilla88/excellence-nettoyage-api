package com.villacamp.hn.excellence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Long id;
    private String name;
    private String description;
    private String address;
}
