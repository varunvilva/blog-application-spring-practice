package com.varunvilva.blog.controller;

import com.varunvilva.blog.dto.in.LoginRequest;
import com.varunvilva.blog.dto.out.AuthResponse;
import com.varunvilva.blog.security.BlogUserDetails;
import com.varunvilva.blog.service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        BlogUserDetails user = (BlogUserDetails)authenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        AuthResponse authResponse = AuthResponse.builder()
                .token(authenticationService.generateToken(user))
                .expiresIn(86400) // 24 hours in seconds
                .build();

        return ResponseEntity.ok(authResponse);
    }
}
