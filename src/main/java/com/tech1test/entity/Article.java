package com.tech1test.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "articles")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Enumerated(EnumType.STRING)
    private Color color;

    public Article() {
    }

    public Article(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public Article(Long id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }
}
