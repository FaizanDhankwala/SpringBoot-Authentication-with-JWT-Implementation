package com.alibou.demo.auth;

import com.alibou.demo.config.JwtService;
import com.alibou.demo.user.Role;
import com.alibou.demo.user.User;
import com.alibou.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service

public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Encode the password
                .role(Role.USER)
                .build();

        repository.save(user); // Save user to DB
        var jwtToken = jwtService.generateToken(user); // Generate JWT token
        return AuthenticationResponse.builder()
                .token(jwtToken) // Return the JWT token
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found")); // Retrieve user from DB

        var jwtToken = jwtService.generateToken(user); // Generate JWT token
        return AuthenticationResponse.builder()
                .token(jwtToken) // Return the JWT token
                .build();
    }
}
