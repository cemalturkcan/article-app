package com.article.basicarticle.domain.application.web;

import com.article.basicarticle.domain.application.api.DomainDto;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DomainRequest {
    private final String name;
    private final String id;
    private final String code;

    public DomainDto toDto() {
        return DomainDto.builder()
                .id(this.id)
                .code(this.code)
                .name(this.name)
                .build();
    }
}
