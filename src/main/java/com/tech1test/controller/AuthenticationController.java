package com.tech1test.controller;

import com.tech1test.dto.request.UserLoginDto;
import com.tech1test.dto.request.UserRegistrationDto;
import com.tech1test.dto.response.UserCredentialsResponseDto;
import com.tech1test.entity.UserCredentials;
import com.tech1test.exception.AuthenticationException;
import com.tech1test.security.AuthenticationService;
import com.tech1test.security.jwt.JwtTokenProvider;
import com.tech1test.service.mapper.UserCredentialsMapper;
import java.util.Collections;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserCredentialsMapper userCredentialsMapper;
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public UserCredentialsResponseDto register(
            @RequestBody @Valid UserRegistrationDto userRegistrationDto
    ) {
        UserCredentials userCredentials = authenticationService
                .register(userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
        return userCredentialsMapper.toDto(userCredentials);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto userLoginDto)
            throws AuthenticationException {
        UserCredentials userCredentials = authenticationService.login(
                userLoginDto.getEmail(), userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(userCredentials.getEmail());
        return new ResponseEntity<>(Collections.singletonMap("token", token), HttpStatus.OK);
    }
}
