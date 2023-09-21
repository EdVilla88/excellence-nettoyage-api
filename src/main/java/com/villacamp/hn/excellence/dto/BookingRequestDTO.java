package com.villacamp.hn.excellence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
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
    @Schema(description = "Address id", example = "1")
    private long addressId;
    @Schema(description = "Job's id", example = "1")
    private long jobId;
    @Future
    @Schema(description = "Job's booked date and time.", example = "2024-09-21T00:17:53.792Z")
    @NotNull(message = "bookedDateTime cannot be null")
    private LocalDateTime bookedDateTime;
    @Schema(description = "Entire location size sq/ft", example = "2000")
    private int locationSize;
    @Schema(description = "Location number of rooms", example = "4")
    private int rooms;
    @Schema(description = "Client phone", example = "+540113123698")
    private String phone;
}
