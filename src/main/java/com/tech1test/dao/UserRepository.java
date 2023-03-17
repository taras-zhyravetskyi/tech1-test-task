package com.tech1test.dao;

import com.tech1test.entity.Color;
import com.tech1test.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u "
            + "FROM User u "
            + "LEFT JOIN u.articles a "
            + "WHERE u.age > :age")
    List<User> findByAgeGreaterThan(@Param("age") Integer age);

    @Query("SELECT u "
            + "FROM User u "
            + "JOIN FETCH u.articles a "
            + "WHERE a.color = :color")
    List<User> findByArticlesColor(@Param("color") Color color);

    @Query("SELECT DISTINCT u.name "
            + "FROM User u "
            + "LEFT JOIN u.articles a "
            + "GROUP BY u.id "
            + "HAVING COUNT(a) > :count")
    List<String> findUniqueNamesWithMoreArticlesThan(@Param("count") Long count);
}
