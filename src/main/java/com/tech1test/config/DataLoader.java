package com.tech1test.config;

import java.util.Random;
import com.tech1test.constants.ApplicationConstants;
import com.tech1test.entity.Article;
import com.tech1test.entity.User;
import com.tech1test.service.ArticleService;
import com.tech1test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private static final int MAX_ARTICLES  = 7;
    private UserService userService;
    private ArticleService articleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("User " + i);
            user.setAge(random.nextInt(ApplicationConstants.MAX_USER_AGE)
                    + ApplicationConstants.MIN_USER_AGE);
            userService.save(user);

            for (int j = 0; j < random.nextInt(MAX_ARTICLES); j++) {
                Article article = new Article();
                article.setText("Article " + j);
                article.setColor(Article.Color.values()
                        [random.nextInt(Article.Color.values().length)]);
                articleService.save(article);
            }
        }
    }
}
