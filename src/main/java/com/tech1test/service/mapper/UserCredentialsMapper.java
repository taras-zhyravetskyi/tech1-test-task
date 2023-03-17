package com.tech1test.service.mapper;

import com.tech1test.dto.response.UserCredentialsResponseDto;
import com.tech1test.entity.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCredentialsMapper {
    public UserCredentialsResponseDto toDto(UserCredentials userCredentials) {
        UserCredentialsResponseDto dto = new UserCredentialsResponseDto();
        dto.setId(userCredentials.getId());
        dto.setEmail(userCredentials.getEmail());
        return dto;
    }
}
