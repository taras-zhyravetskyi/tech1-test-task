package com.tech1test.service.mapper;

import com.tech1test.dto.request.UserRequestDto;
import com.tech1test.dto.response.UserResponseDto;
import com.tech1test.dto.response.UserWithArticlesResponseDto;
import com.tech1test.entity.User;
import com.tech1test.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRequestDto, User> {
    private final ArticleService articleService;

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setArticleIds(user.getArticles().stream()
                .map(article -> article.getId())
                .collect(Collectors.toList()));
        return userResponseDto;
    }

    @Override
    public User mapToEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setArticles(dto.getArticleIds().stream()
                .map(id -> articleService.get(id))
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
