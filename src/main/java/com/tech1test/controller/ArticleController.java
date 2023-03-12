package com.tech1test.controller;


import com.tech1test.dto.request.ArticleRequestDto;
import com.tech1test.dto.response.ArticleResponseDto;
import com.tech1test.entity.Article;
import com.tech1test.service.ArticleService;
import com.tech1test.service.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @PostMapping
    public ArticleResponseDto addArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        Article article = articleMapper.mapToEntity(articleRequestDto);
        articleService.save(article);
        return articleMapper.mapToDto(article);
    }
}
