package com.tech1test.controller;

import com.tech1test.dto.request.UserRequestDto;
import com.tech1test.dto.response.UserResponseDto;
import com.tech1test.dto.response.UserWithArticlesResponseDto;
import com.tech1test.entity.Article;
import com.tech1test.entity.User;
import com.tech1test.service.UserService;
import com.tech1test.service.mapper.UserMapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/articles")
    public List<UserWithArticlesResponseDto> getWithArticlesByColor(
            @RequestParam Article.Color color) {
        List<User> users = userService.getWithArticlesByColor(color);
        return users.stream()
                        .map(userMapper::mapToDtoWithArticles)
                        .collect(Collectors.toList());
    }

    @GetMapping
    public List<User> getByAgeGreaterThan(@RequestParam(required = false) Integer age) {
            return userService.getByAgeGreaterThan(age);
    }

    @GetMapping("/unique-names/{articles}")
    public Set<String> getUniqueNamesWithMoreArticlesThan(@PathVariable Integer articles) {
        return userService.getUniqueNamesWithMoreArticlesThan(articles);
    }

    @PostMapping
    public User addUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userMapper.mapToEntity(userRequestDto);
        return userService.save(user);
    }
}
