package com.article.basicarticle.domain.application.web;

import com.article.basicarticle.domain.application.api.DomainDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DomainResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String code;

    public static DomainResponse fromDto(DomainDto domain){
        return DomainResponse.builder()
                .id(domain.getId())
                .created(domain.getCreated())
                .modified(domain.getModified())
                .name(domain.getName())
                .code(domain.getCode())
                .build();
    }
}
