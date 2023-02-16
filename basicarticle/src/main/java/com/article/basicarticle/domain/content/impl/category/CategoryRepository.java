package com.article.basicarticle.domain.content.impl.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,String> {
    Optional<Category> findCategoryByCode(String code);
    Optional<Category> findAllByCode(String code);
}
