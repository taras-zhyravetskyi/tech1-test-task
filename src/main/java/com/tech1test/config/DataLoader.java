package com.tech1test.config;

import com.tech1test.constants.ApplicationConstants;
import com.tech1test.entity.Article;
import com.tech1test.entity.Color;
import com.tech1test.entity.User;
import com.tech1test.security.AuthenticationService;
import com.tech1test.service.ArticleService;
import com.tech1test.service.UserService;
import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader {
    private static final int MAX_ARTICLES = 7;
    private static final String DEFAULT_EMAIL = "bob@gmail.com";
    private static final String DEFAULT_PASSWORD = "12345678";

    private UserService userService;
    private ArticleService articleService;
    private AuthenticationService authenticationService;

    @PostConstruct
    public void init() {
        Random random = new Random();
        authenticationService.register(DEFAULT_EMAIL, DEFAULT_PASSWORD);

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("User " + i);
            user.setAge(random.nextInt(ApplicationConstants.MAX_USER_AGE)
                    + ApplicationConstants.MIN_USER_AGE);
            user.setArticles(new ArrayList<Article>());

            for (int j = 0; j < random.nextInt(MAX_ARTICLES); j++) {
                Article article = new Article();
                article.setText("Article " + j);
                article.setColor(Color.values()
                        [random.nextInt(Color.values().length)]);
                articleService.save(article);
                user.getArticles().add(article);
            }
            userService.save(user);
        }
    }
}
