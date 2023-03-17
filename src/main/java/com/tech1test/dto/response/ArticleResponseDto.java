package com.tech1test.dto.response;

import com.tech1test.entity.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ArticleResponseDto {
    private Long id;
    private String text;
    private Color color;
}
