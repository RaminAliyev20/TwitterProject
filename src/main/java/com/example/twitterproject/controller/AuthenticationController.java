package com.example.twitterproject.controller;

import com.example.twitterproject.model.dto.AuthenticationDto;
import com.example.twitterproject.model.dto.requestDto.AuthRequestDto;
import com.example.twitterproject.model.dto.requestDto.UserRegisterRequestDto;
import com.example.twitterproject.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationDto> register(
            @RequestBody UserRegisterRequestDto requestDto
    ) {
        return ResponseEntity.ok(authService.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> register(
            @RequestBody AuthRequestDto authRequestDto
    ) {
        return ResponseEntity.ok(authService.authenticate(authRequestDto));
    }
}
