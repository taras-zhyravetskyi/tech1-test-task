package com.tech1test.dto.response;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private List<Long> articleIds;
}
