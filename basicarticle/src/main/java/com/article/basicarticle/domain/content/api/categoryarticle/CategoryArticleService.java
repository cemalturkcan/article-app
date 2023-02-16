package com.article.basicarticle.domain.content.api.categoryarticle;

import java.util.List;

public interface CategoryArticleService {

    CategoryArticleDto createCategoryArticle(CategoryArticleDto dto);

    List<CategoryArticleDto> getCategoryArticles();

    CategoryArticleDto updateCategoryArticle(String id, CategoryArticleDto dto);

    void deleteCategoryArticle(String id);

    List<CategoryArticleDto> getCategoryArticlesByCategoryNameAndDomainId(String categoryId, String domainId);
}
