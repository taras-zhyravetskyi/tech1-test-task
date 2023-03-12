package com.tech1test.service;

import com.tech1test.entity.Article;
import com.tech1test.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User save(User user);

    User get(Long id);

    List<User> getByAgeGreaterThan(Integer age);

    Set<String> getUniqueNamesWithMoreArticlesThan(Integer articles);

    List<User> getWithArticlesByColor(Article.Color color);
}
