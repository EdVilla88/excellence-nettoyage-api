package com.villacamp.hn.excellence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {
    @Schema(description = "Address name", example = "Office")
    private String name;
    @Schema(description = "Location description", example = "kitchen, bathroom, parking")
    private String description;
    @NotEmpty(message = "address cannot be empty")
    @NotNull(message = "address cannot be null")
    @Schema(description = "Location address", example = "HX7H+26M, C. Hacia Armenta, San Pedro Sula 21102")
    private String address;
}
