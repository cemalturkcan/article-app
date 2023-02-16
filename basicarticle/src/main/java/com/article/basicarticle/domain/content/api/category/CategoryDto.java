package com.article.basicarticle.domain.content.api.category;

import com.article.basicarticle.domain.application.api.DomainDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryDto {
    private final String id;
    private final String name;
    private final String code;
    private final DomainDto domain;
    private final Date created;
    private final Date modified;
}
