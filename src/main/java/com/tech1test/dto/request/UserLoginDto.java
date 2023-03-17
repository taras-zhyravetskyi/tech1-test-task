package com.tech1test.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserLoginDto {
    @NotBlank(message = "Email can't be null or blank!")
    private String email;
    @NotBlank(message = "Password can't be null or blank!")
    private String password;
}
