package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.request.SignInDTO;
import com.villacamp.hn.excellence.dto.request.SignUpDTO;
import com.villacamp.hn.excellence.dto.response.JwtAuthenticationDTO;

public interface AuthenticationService {

    JwtAuthenticationDTO signUp(SignUpDTO request);

    JwtAuthenticationDTO signIn(SignInDTO request);
}
