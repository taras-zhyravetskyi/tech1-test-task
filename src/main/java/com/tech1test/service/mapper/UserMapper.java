package com.tech1test.service.mapper;

import com.tech1test.dto.request.UserRequestDto;
import com.tech1test.dto.response.UserResponseDto;
import com.tech1test.dto.response.UserWithArticlesResponseDto;
import com.tech1test.entity.User;
import com.tech1test.service.ArticleService;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ArticleService articleService;

    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setArticleIds(user.getArticles().stream()
                .map(article -> article.getId())
                .collect(Collectors.toList()));
        return userResponseDto;
    }

    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setArticles(dto.getArticleIds().stream()
                .map(id -> articleService.findById(id))
                .collect(Collectors.toList()));
        return user;
    }

    public UserWithArticlesResponseDto mapToDtoWithArticles(User user) {
        UserWithArticlesResponseDto userWithArticlesResponseDto =
                new UserWithArticlesResponseDto();
        userWithArticlesResponseDto.setId(user.getId());
        userWithArticlesResponseDto.setName(user.getName());
        userWithArticlesResponseDto.setAge(user.getAge());
        userWithArticlesResponseDto.setArticles(user.getArticles());
        return userWithArticlesResponseDto;
    }
}
