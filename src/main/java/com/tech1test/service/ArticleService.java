package com.tech1test.service;

import com.tech1test.entity.Article;

public interface ArticleService {
    Article save(Article article);

    Article get(Long id);
}
