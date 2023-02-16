package com.article.basicarticle.domain.content.impl.categoryarticle;

import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleDto;
import com.article.basicarticle.domain.content.impl.article.Article;
import com.article.basicarticle.domain.content.impl.category.Category;
import com.article.basicarticle.library.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = CategoryArticle.TABLE)
public class CategoryArticle extends AbstractEntity {
    public static final String TABLE = "category_article";
    public static final String CATEGORY = "categoryId";
    public static final String ARTICLE = "articleId";
    public static final String ORDER_NUMBER = "orderNumber";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = CATEGORY)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ARTICLE)
    private Article article;
    @Column(name = ORDER_NUMBER, nullable = false)
    private String orderNumber;

    public CategoryArticleDto toDto(){
        return CategoryArticleDto.builder()
                .id(this.getId())
                .created(this.getCreated())
                .modified(this.getModified())
                .orderNumber(this.getOrderNumber())
                .category(this.getCategory().toDto())
                .article(this.getArticle().toDto())
                .build();
    }

}
