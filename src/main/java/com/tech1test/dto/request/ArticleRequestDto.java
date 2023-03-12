package com.tech1test.dto.request;

import com.tech1test.entity.Article;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@RequiredArgsConstructor
@Setter
public class ArticleRequestDto {
    private String text;
    private Article.Color color;
}
