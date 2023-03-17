package com.tech1test.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class UserCredentialsResponseDto {
    private Long id;
    private String email;
}
