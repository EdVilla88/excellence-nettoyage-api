package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.JwtAuthenticationDTO;
import com.villacamp.hn.excellence.dto.SignInDTO;
import com.villacamp.hn.excellence.dto.SignUpDTO;

public interface AuthenticationService {

    JwtAuthenticationDTO signUpClient(SignUpDTO request);

    JwtAuthenticationDTO signInClient(SignInDTO request);
}
