package com.article.basicarticle.domain.content.web.article;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.author.AuthorDto;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ArticleRequest {
    private final String title;
    private final String htmlBody;
    private final boolean active;
    private final String seoTitle;
    private final String seoDescription;
    private final String slug;
    private final Set<String> seoKeywords;
    private final String authorId;

    public ArticleDto toDto(){
        return ArticleDto.builder()
                .title(title)
                .active(active)
                .slug(slug)
                .seoTitle(seoTitle)
                .seoDescription(seoDescription)
                .seoKeywords(seoKeywords)
                .htmlBody(htmlBody)
                .author(AuthorDto.builder().id(authorId).build())
                .build();
    }
}
