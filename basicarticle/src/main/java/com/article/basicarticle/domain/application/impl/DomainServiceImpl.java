package com.article.basicarticle.domain.application.impl;

import com.article.basicarticle.domain.application.api.DomainDto;
import com.article.basicarticle.domain.application.api.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {
    private final DomainRepository repository;

    @Override
    @Transactional
    public DomainDto createDomain(DomainDto dto) {
        checkDomainExist(dto);
        Domain domain = new Domain();
        setDomainFromDto(dto, domain);
        return repository.save(domain).toDto();
    }

    @Override
    public List<DomainDto> getDomains() {
        return repository.findAll().stream()
                .map(Domain::toDto)
                .toList();
    }

    @Override
    @Transactional
    public DomainDto updateDomain(String id, DomainDto dto) {
        return repository.findById(id)
                .map(domain -> setDomainFromDto(dto, domain))
                .map(repository::save)
                .map(Domain::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public DomainDto getDomainById(String id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).toDto();
    }

    @Override
    public DomainDto getDomain(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Domain not found exception")).toDto();
    }

    @Override
    public void deleteDomain(String id) {
        repository.delete(repository.findById(id).orElseThrow(EntityExistsException::new));
    }

    private Domain setDomainFromDto(DomainDto dto, Domain domain) {
        domain.setName(dto.getName());
        domain.setCode(dto.getCode());
        return domain;
    }

    private void checkDomainExist(DomainDto dto) {
        repository.findByName(dto.getName()).ifPresent(domain -> {
            throw new EntityExistsException(
                    String.format("Entity %s already exists", domain.getName())
            );
        });
    }
}
