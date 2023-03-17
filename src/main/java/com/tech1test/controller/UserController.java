package com.tech1test.controller;

import com.tech1test.dto.request.UserRequestDto;
import com.tech1test.dto.response.UserResponseDto;
import com.tech1test.dto.response.UserWithArticlesResponseDto;
import com.tech1test.entity.Color;
import com.tech1test.entity.User;
import com.tech1test.service.UserService;
import com.tech1test.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/articles/{color}")
    public List<UserWithArticlesResponseDto> findByArticlesColor(
            @PathVariable Color color) {
        List<User> users = userService.findByArticlesColor(color);
        return users.stream()
                        .map(userMapper::mapToDtoWithArticles)
                        .collect(Collectors.toList());
    }

    @GetMapping
    public List<UserResponseDto> findByAgeGreaterThan(
            @RequestParam(required = false, defaultValue = "0") Integer ageGreaterThan) {
        return userService.findByAgeGreaterThan(ageGreaterThan).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/unique-names/articles/{articles}")
    public List<String> findUniqueNamesWithMoreArticlesThan(@PathVariable Long articles) {
        return userService.findUniqueNamesWithMoreArticlesThan(articles);
    }

    @PostMapping
    public UserResponseDto save(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        return userMapper.toDto(userService.save(user));
    }
}
