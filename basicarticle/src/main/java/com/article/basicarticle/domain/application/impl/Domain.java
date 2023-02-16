package com.article.basicarticle.domain.application.impl;

import com.article.basicarticle.domain.application.api.DomainDto;
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
@Table(name = Domain.TABLE,
        indexes = {
                @Index(name = Domain.NAME_INDEX, columnList = Domain.COL_NAME)
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = Domain.COL_NAME)
        })
public class Domain extends AbstractEntity {
    public static final String TABLE = "domain";
    public static final String NAME_INDEX = "domain_i_name";
    public static final String COL_NAME = "name";
    public static final String COL_CODE = "code";

    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(name = COL_CODE, nullable = false)
    private String code;

    public DomainDto toDto(){
        return DomainDto.builder()
                .id(this.getId())
                .created(this.getCreated())
                .modified(this.getModified())
                .name(this.getName())
                .code(this.getCode())
                .build();
    }

}
