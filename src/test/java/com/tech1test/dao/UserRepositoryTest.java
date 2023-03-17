package com.tech1test.dao;

import com.tech1test.entity.Article;
import com.tech1test.entity.Color;
import com.tech1test.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testFindByAgeGreaterThan() {
        User user1 = new User("John", 30);
        User user2 = new User("Alice", 23);
        User user3 = new User("Kate", 51);
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        List<User> users = userRepository.findByAgeGreaterThan(30);

        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(user3, users.get(0));
    }

    @Test
    public void testFindByArticlesColor() {
        Article article1 = new Article("Article 1", Color.RED);
        Article article2 = new Article("Article 2", Color.BLUE);
        Article article3 = new Article("Article 3", Color.GREEN);
        Article article4 = new Article("Article 4", Color.BLUE);
        Article article5 = new Article("Article 5", Color.PINK);
        Article article6 = new Article("Article 6", Color.RED);
        List<Article> articles = Arrays.asList(article1, article2, article3, article4, article5, article6);
        articleRepository.saveAll(articles);

        User user1 = new User("John", 25);
        user1.setArticles(Arrays.asList(article1, article2));
        User user2 = new User("Jane", 30);
        user2.setArticles(Arrays.asList(article3, article4, article5, article6));
        userRepository.saveAll(Arrays.asList(user1, user2));

        List<User> users = userRepository.findByArticlesColor(Color.RED);

        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals(2, users.stream()
                .flatMap(u -> u.getArticles().stream())
                .filter(a -> a.getColor().equals(Color.RED))
                .collect(Collectors.toList()).size());
    }

    @Test
    public void testFindUniqueNamesWithMoreArticlesThan() {
        Article article1 = new Article("Article 1", Color.RED);
        Article article2 = new Article("Article 2", Color.BLUE);
        Article article3 = new Article("Article 3", Color.GREEN);
        Article article4 = new Article("Article 4", Color.BLUE);
        Article article5 = new Article("Article 5", Color.PINK);
        Article article6 = new Article("Article 6", Color.RED);
        Article article7 = new Article("Article 7", Color.WHITE);
        List<Article> articles = Arrays.asList(article1, article2, article3, article4, article5, article6, article7);
        articleRepository.saveAll(articles);

        User user1 = new User("John", 25);
        user1.setArticles(Arrays.asList(article1, article2));
        User user2 = new User("Jane", 30);
        user2.setArticles(Arrays.asList(article3, article4, article5, article6));
        User user3 = new User("Mike", 35);
        user3.setArticles(Arrays.asList(article7));
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        List<String> names = userRepository.findUniqueNamesWithMoreArticlesThan(3l);

        Assertions.assertEquals(1, names.size());
        Assertions.assertEquals("Jane", names.get(0));
    }
}
