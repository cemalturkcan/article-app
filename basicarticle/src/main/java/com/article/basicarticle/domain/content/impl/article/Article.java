package com.article.basicarticle.domain.content.impl.article;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.impl.author.Author;
import com.article.basicarticle.library.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Article.TABLE)
public class Article extends AbstractEntity {
    public static final String TABLE = "article";
    public static final String COL_TITLE = "title";
    public static final String COL_ABSTRACT = "articleAbstract";
    public static final String COL_BODY = "body";
    public static final String COL_IMAGE = "image";
    public static final String COL_VIDEO = "video";
    public static final String COL_TYPE = "type";
    public static final String COL_ACTIVE = "active";
    public static final String AUTHOR = "authorId";
    public static final String COL_HTML_BODY = "htmlBody";
    public static final String COL_SEO_TITLE = "seoTitle";
    public static final String COL_SEO_DESCRIPTION = "seoDescription";
    public static final String COL_SEO_KEYWORDS = "seoKeywords";
    public static final String COL_SLUG = "slug";
    public static final String COL_CATEGORY_TITLE = "categoryTitle";


    @Column(name = COL_TITLE, nullable = false)
    private String title;
    @Column(name = COL_HTML_BODY, nullable = false, length = 60000, columnDefinition = "TEXT")
    private String htmlBody;
    @Column(name = COL_SEO_TITLE, nullable = false, length = 256, columnDefinition = "TEXT")
    private String seoTitle;
    @Column(name = COL_SEO_DESCRIPTION, nullable = false, length = 256, columnDefinition = "TEXT")
    private String seoDescription;
    @Column(name = COL_SLUG, nullable = false)
    private String slug;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = COL_SEO_KEYWORDS, nullable = false)
    private Set<String> seoKeywords;
    @Column(name = COL_ACTIVE, nullable = false)
    private Boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = AUTHOR)
    private Author author;

    public ArticleDto toDto() {
        return ArticleDto.builder()
                .id(this.getId())
                .created(this.getCreated())
                .modified(this.getModified())
                .seoTitle(this.getSeoTitle())
                .seoDescription(this.getSeoDescription())
                .slug(this.getSlug())
                .seoKeywords(this.getSeoKeywords())
                .htmlBody(this.getHtmlBody())
                .active(this.getActive())
                .author(this.getAuthor().toDto())
                .title(this.getTitle())
                .build();
    }

}
