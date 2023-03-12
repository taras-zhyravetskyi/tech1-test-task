package com.tech1test.dto.response;

import com.tech1test.entity.Article;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class ArticleResponseDto {
    private Long id;
    private String text;
    private Article.Color color;
}
