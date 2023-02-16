package com.article.basicarticle.domain.content.web.category;

import com.article.basicarticle.domain.application.api.DomainDto;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryResponse {

    private final String id;
    private final String name;
    private final String code;
    private final DomainDto domain;
    private final Date created;
    private final Date modified;

    public static CategoryResponse fromDto(CategoryDto dto) {
        return CategoryResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .code(dto.getCode())
                .domain(dto.getDomain())
                .build();
    }
}
