package com.villacamp.hn.excellence.controller;

import com.villacamp.hn.excellence.dto.JwtAuthenticationDTO;
import com.villacamp.hn.excellence.dto.SignInDTO;
import com.villacamp.hn.excellence.dto.SignUpDTO;
import com.villacamp.hn.excellence.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/auth")
@RequiredArgsConstructor
@SecurityRequirements({@SecurityRequirement(name = "api-key")})
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    @Operation(summary = "Sign up with a new email and password.")
    public ResponseEntity<JwtAuthenticationDTO> signUp(@Valid @RequestBody SignUpDTO request) {
        return ResponseEntity.ok(authenticationService.signUpClient(request));
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Sign in with an email and password.")
    public ResponseEntity<JwtAuthenticationDTO> signIn(@Valid @RequestBody SignInDTO request) {
        return ResponseEntity.ok(authenticationService.signInClient(request));
    }
}
