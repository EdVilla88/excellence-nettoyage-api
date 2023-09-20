package com.villacamp.hn.excellence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {
    @NotEmpty(message = "address cannot be empty")
    @Schema(description = "Address name", example = "Office")
    private long addressId;
    @NotEmpty(message = "address cannot be empty")
    @Schema(description = "Address name", example = "Office")
    private long jobId;
    @Schema(description = "Address name", example = "Office")
    @NotEmpty(message = "address cannot be empty")
    @NotNull(message = "address cannot be null")
    private LocalDateTime bookedDateTime;
    @Schema(description = "Address name", example = "Office")
    private int locationSize;
    @Schema(description = "Address name", example = "Office")
    private int rooms;
    @Schema(description = "Address name", example = "Office")
    private String phone;
}
