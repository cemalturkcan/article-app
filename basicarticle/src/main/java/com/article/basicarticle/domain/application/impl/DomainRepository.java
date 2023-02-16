package com.article.basicarticle.domain.application.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DomainRepository extends JpaRepository<Domain, String> {
    Optional<Domain> findByName(String name);

}
