package com.article.basicarticle.domain.content.impl.category;

import com.article.basicarticle.domain.application.api.DomainDto;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import com.article.basicarticle.library.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Category.TABLE)
public class Category extends AbstractEntity {
    public static final String TABLE = "category";
    public static final String COL_NAME = "name";
    public static final String COL_CODE = "code";
    public static final String DOMAIN = "domainId";

    @Column(name = COL_NAME, nullable = false)
    private String name;
    @Column(name = COL_CODE, nullable = false)
    private String code;

    @Column(name = DOMAIN)
    private String domainId;

    public CategoryDto toDto(){
        return CategoryDto.builder()
                .id(this.getId())
                .created(this.getCreated())
                .modified(this.getModified())
                .name(this.getName())
                .code(this.getCode())
                .domain(DomainDto.builder().id(this.getDomainId()).build())
                .build();
    }

}
