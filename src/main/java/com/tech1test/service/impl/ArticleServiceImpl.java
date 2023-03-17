package com.tech1test.service.impl;

import com.tech1test.dao.ArticleRepository;
import com.tech1test.entity.Article;
import com.tech1test.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can`t find article with id " + id));
    }
}
