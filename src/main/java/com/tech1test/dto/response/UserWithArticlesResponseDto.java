package com.tech1test.dto.response;

import java.util.List;

import com.tech1test.entity.Article;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class UserWithArticlesResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private List<Article> articles;
}
