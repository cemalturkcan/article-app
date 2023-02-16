package com.article.basicarticle.domain.content.api.article;

import com.article.basicarticle.domain.content.api.author.AuthorDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class ArticleDto {
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
    private final AuthorDto author;

}
