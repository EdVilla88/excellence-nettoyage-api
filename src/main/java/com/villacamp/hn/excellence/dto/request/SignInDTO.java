package com.villacamp.hn.excellence.dto.request;

import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInDTO {
    @Email
    private String email;
    @NonNull
    private String password;
}
