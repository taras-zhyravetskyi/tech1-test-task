package com.tech1test.service.impl;

import com.tech1test.dao.UserRepository;
import com.tech1test.entity.Color;
import com.tech1test.entity.User;
import com.tech1test.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findByAgeGreaterThan(Integer age) {
        return userRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<User> findByArticlesColor(Color color) {
        return userRepository.findByArticlesColor(color);
    }

    @Override
    public List<String> findUniqueNamesWithMoreArticlesThan(Long articles) {
        return userRepository.findUniqueNamesWithMoreArticlesThan(articles);
    }
}
