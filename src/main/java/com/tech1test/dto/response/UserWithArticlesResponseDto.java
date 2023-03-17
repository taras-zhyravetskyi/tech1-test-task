package com.tech1test.dto.response;

import com.tech1test.entity.Article;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserWithArticlesResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private List<Article> articles;
}
