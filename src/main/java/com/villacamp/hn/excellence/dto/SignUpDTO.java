package com.villacamp.hn.excellence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
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
public class SignUpDTO {
    @NotNull
    @NotEmpty
    @Schema(description = "User's full name", example = "John Doe")
    private String fullName;
    @Email
    @Schema(description = "Account's email", example = "test@email.com")
    private String email;
    @NotNull
    @NotEmpty
    @Schema(description = "Account's password", example = "test123!")
    private String password;
    @NotNull
    @NotEmpty
    @Schema(description = "User's phone number with region code", example = "+50411111111")
    private String phone;
}
