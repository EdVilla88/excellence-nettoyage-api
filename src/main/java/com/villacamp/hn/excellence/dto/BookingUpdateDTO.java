package com.villacamp.hn.excellence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookingUpdateDTO extends BookingRequestDTO {
    @NotNull
    @Schema(description = "Booking identifier", example = "1")
    private long id;
}
