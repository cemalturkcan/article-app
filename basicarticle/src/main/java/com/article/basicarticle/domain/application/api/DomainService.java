package com.article.basicarticle.domain.application.api;

import java.util.List;

public interface DomainService {
    DomainDto createDomain(DomainDto dto);

    List<DomainDto> getDomains();

    DomainDto updateDomain(String id, DomainDto dto);

    DomainDto getDomainById(String id);


    DomainDto getDomain(String id);

    void deleteDomain(String id);
}
