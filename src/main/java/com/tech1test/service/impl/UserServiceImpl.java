package com.tech1test.service.impl;

import com.tech1test.entity.Article;
import com.tech1test.entity.User;
import com.tech1test.service.UserService;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<User> getByAgeGreaterThan(Integer age) {
        return null;
    }

    @Override
    public Set<String> getUniqueNamesWithMoreArticlesThan(Integer articles) {
        return null;
    }

    @Override
    public List<User> getWithArticlesByColor(Article.Color color) {
        return null;
    }
}
