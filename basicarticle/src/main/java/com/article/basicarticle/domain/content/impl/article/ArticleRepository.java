package com.article.basicarticle.domain.content.impl.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,String> {
    Optional<Article> findArticleByTitle(String title);
    Optional<Article> findArticleBySlug(String slug);
}
