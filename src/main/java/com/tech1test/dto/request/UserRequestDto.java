package com.tech1test.dto.request;

import com.tech1test.constants.ApplicationConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class UserRequestDto {
    private String name;
    @Min(ApplicationConstants.MIN_USER_AGE)
    @Max(ApplicationConstants.MAX_USER_AGE)
    private Integer age;
    private List<Long> articleIds;
}
