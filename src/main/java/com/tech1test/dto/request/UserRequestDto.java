package com.tech1test.dto.request;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {
    private static final int MIN_USER_AGE = 10;
    private static final int MAX_USER_AGE = 100;

    private String name;
    @Min(MIN_USER_AGE)
    @Max(MAX_USER_AGE)
    private Integer age;
    private List<Long> articleIds;
}
