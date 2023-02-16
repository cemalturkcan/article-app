package com.article.basicarticle.domain.content.api.categoryarticle;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryArticleDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private String orderNumber;
    private CategoryDto category;
    private ArticleDto article;
}
