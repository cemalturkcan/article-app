package com.article.basicarticle.domain.content.api.article;

import com.article.basicarticle.domain.content.impl.article.Article;

import java.util.List;

public interface ArticleService {

    ArticleDto createArticle(ArticleDto dto);


    List<ArticleDto> getArticles();


    ArticleDto updateArticle(String id, ArticleDto dto);


    Article getArticleById(String id);

    void deleteArticle(String id);
    ArticleDto defineArticleBySlug(String slug);
}
