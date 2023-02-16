package com.article.basicarticle.domain.content.web.article;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.author.AuthorDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class ArticleResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String title;
    private final String htmlBody;
    private final String seoTitle;
    private final String seoDescription;
    private final String slug;
    private final Set<String> seoKeywords;
    private final boolean active;
    private AuthorDto author;

    public static ArticleResponse fromDto(ArticleDto dto){
        return ArticleResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .title(dto.getTitle())
                .htmlBody(dto.getHtmlBody())
                .seoDescription(dto.getSeoDescription())
                .seoTitle(dto.getSeoTitle())
                .slug(dto.getSlug())
                .seoKeywords(dto.getSeoKeywords())
                .active(dto.isActive())
                .author(dto.getAuthor())
                .build();
    }
}
