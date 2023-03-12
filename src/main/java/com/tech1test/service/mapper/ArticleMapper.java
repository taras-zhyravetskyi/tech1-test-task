package com.tech1test.service.mapper;

import com.tech1test.dto.request.ArticleRequestDto;
import com.tech1test.dto.response.ArticleResponseDto;
import com.tech1test.entity.Article;

public class ArticleMapper implements ResponseDtoMapper<ArticleResponseDto, Article>,
        RequestDtoMapper<ArticleRequestDto, Article> {

    @Override
    public Article mapToEntity(ArticleRequestDto dto) {
        Article article = new Article();
        article.setText(dto.getText());
        article.setColor(dto.getColor());
        return article;
    }

    @Override
    public ArticleResponseDto mapToDto(Article article) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setText(article.getText());
        articleResponseDto.setColor(article.getColor());
        return articleResponseDto;
    }
}
