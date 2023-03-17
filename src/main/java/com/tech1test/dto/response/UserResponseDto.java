package com.tech1test.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private List<Long> articleIds;
}
