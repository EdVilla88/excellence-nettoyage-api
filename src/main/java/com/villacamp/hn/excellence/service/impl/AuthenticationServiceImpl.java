package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.dto.JwtAuthenticationDTO;
import com.villacamp.hn.excellence.dto.SignInDTO;
import com.villacamp.hn.excellence.dto.SignUpDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.repository.UserRepository;
import com.villacamp.hn.excellence.service.AuthenticationService;
import com.villacamp.hn.excellence.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public JwtAuthenticationDTO signUpClient(SignUpDTO request) {
        var user = User.builder()
                .name(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhone())
                .created(LocalDateTime.now())
                .role(request.getRole())
                .build();
        userRepository.save(user);

        return JwtAuthenticationDTO.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public JwtAuthenticationDTO signInClient(SignInDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        return JwtAuthenticationDTO.builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
