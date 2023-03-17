package com.tech1test.dto.request;

import com.tech1test.entity.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ArticleRequestDto {
    private String text;
    private Color color;
}
