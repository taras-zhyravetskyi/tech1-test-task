package com.tech1test.service.mapper;

import com.tech1test.dto.request.ArticleRequestDto;
import com.tech1test.dto.response.ArticleResponseDto;
import com.tech1test.entity.Article;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class ArticleMapper {
    public ArticleResponseDto toDto(Article article) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setText(article.getText());
        articleResponseDto.setColor(article.getColor());
        return articleResponseDto;
    }

    public Article toEntity(ArticleRequestDto dto) {
        Article article = new Article();
        article.setText(dto.getText());
        article.setColor(dto.getColor());
        return article;
    }
}
