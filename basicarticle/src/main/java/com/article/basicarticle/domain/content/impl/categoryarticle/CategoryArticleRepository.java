package com.article.basicarticle.domain.content.impl.categoryarticle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryArticleRepository extends JpaRepository<CategoryArticle,String> {
    Optional<CategoryArticle> findCategoryArticleByOrderNumber(String orderNumber);
    List<CategoryArticle> findCategoryArticleByCategoryNameAndCategoryDomainId(String categoryId, String domainId);
}
