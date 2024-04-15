package com.example.twitterproject.service.auth;


import com.example.twitterproject.dao.entity.UserEntity;
import com.example.twitterproject.dao.repository.UserRepository;
import com.example.twitterproject.model.dto.AuthenticationDto;
import com.example.twitterproject.model.dto.requestDto.UserRegisterRequestDto;
import com.example.twitterproject.service.JwtService;
import com.example.twitterproject.model.dto.requestDto.AuthRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    public AuthenticationDto register(UserRegisterRequestDto requestDto) {
        var user = UserEntity.builder()
                .firstname(requestDto.getFirstname())
                .lastname(requestDto.getLastname())
                .username(requestDto.getUsername())
                .phoneNumber(requestDto.getPhoneNumber())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationDto authenticate(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getEmail(),
                        authRequestDto.getPassword()
                )
        );

        UserEntity user = userRepository.findUserByEmail(authRequestDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }
}
