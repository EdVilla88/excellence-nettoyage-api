package com.villacamp.hn.excellence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDTO {
    @NotEmpty(message = "title cannot be empty")
    @NotNull(message = "title cannot be null")
    @Schema(description = "Job's title", example = "House cleaning")
    private String title;
    @NotEmpty(message = "description cannot be empty")
    @NotNull(message = "description cannot be null")
    @Schema(description = "Jobs description", example = "Example description for house cleaning.")
    private String description;
    @NotNull(message = "price cannot be null")
    @Schema(description = "Job's price", example = "99.99")
    private BigDecimal price;
    @NotNull(message = "userId cannot be null")
    @Schema(description = "User's id", example = "9")
    private long userId;
}
