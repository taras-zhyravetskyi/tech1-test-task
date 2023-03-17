package com.tech1test.service;

import com.tech1test.entity.Color;
import com.tech1test.entity.User;
import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findByAgeGreaterThan(Integer age);

    List<String> findUniqueNamesWithMoreArticlesThan(Long articles);

    List<User> findByArticlesColor(Color color);
}
