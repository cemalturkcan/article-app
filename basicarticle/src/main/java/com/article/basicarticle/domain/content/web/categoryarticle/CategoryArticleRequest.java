package com.article.basicarticle.domain.content.web.categoryarticle;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CategoryArticleRequest {
    @NotBlank
    private final String orderNumber;
    private final String categoryId;
    private final String articleId;

    public CategoryArticleDto toDto(){
        return CategoryArticleDto.builder()
                .orderNumber(orderNumber)
                .category(CategoryDto.builder().id(categoryId).build())
                .article(ArticleDto.builder().id(articleId).build())
                .build();
    }

}
