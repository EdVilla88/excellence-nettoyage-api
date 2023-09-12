package com.villacamp.hn.excellence.dto.request;

import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    @NonNull
    private String fullName;
    @Email
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String phone;
}
