package com.article.basicarticle.domain.content.web.categoryarticle;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryArticleResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String orderNumber;
    private CategoryDto category;
    private ArticleDto article;

    public static CategoryArticleResponse fromDto(CategoryArticleDto dto){
        return CategoryArticleResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .orderNumber(dto.getOrderNumber())
                .category(dto.getCategory())
                .article(dto.getArticle())
                .build();
    }
}
