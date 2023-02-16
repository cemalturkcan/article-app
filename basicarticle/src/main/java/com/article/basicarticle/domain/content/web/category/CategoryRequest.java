package com.article.basicarticle.domain.content.web.category;

import com.article.basicarticle.domain.application.api.DomainDto;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CategoryRequest {
    @NotBlank
    private final String name;
    @NotBlank
    private final String code;
    private final String  domainId;

    public CategoryDto toDto() {
        return CategoryDto.builder()
                .name(this.name)
                .code(this.code)
                .domain(DomainDto.builder().id(this.domainId).build())
                .build();
    }

}
