package com.article.basicarticle.domain.content.impl.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,String> {
    Optional<Author> findByName (String name);
}
