package com.article.basicarticle.domain.content.impl.categoryarticle;

import com.article.basicarticle.domain.content.api.article.ArticleService;
import com.article.basicarticle.domain.content.api.category.CategoryService;
import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleDto;
import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryArticleServiceImpl implements CategoryArticleService {

    private final CategoryArticleRepository repository;

    private final CategoryService categoryService;

    private final ArticleService articleService;

    @Override
    @Transactional
    public CategoryArticleDto createCategoryArticle(CategoryArticleDto dto) {
        checkCategoryArticleExist(dto);
        CategoryArticle categoryArticle = new CategoryArticle();
        setCategoryArticleFromDto(dto, categoryArticle);
        return repository.save(categoryArticle).toDto();
    }

    @Override
    public List<CategoryArticleDto> getCategoryArticles() {
        return repository.findAll().stream()
                .map(CategoryArticle::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CategoryArticleDto updateCategoryArticle(String id, CategoryArticleDto dto) {
        return repository.findById(id)
                .map(categoryArticle -> setCategoryArticleFromDto(dto, categoryArticle))
                .map(repository::save)
                .map(CategoryArticle::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteCategoryArticle(String id) {
        repository.delete(repository.findById(id).orElseThrow(EntityExistsException::new));
    }

    @Override
    public List<CategoryArticleDto> getCategoryArticlesByCategoryNameAndDomainId(String categoryName, String domainId) {
        return repository.findCategoryArticleByCategoryNameAndCategoryDomainId(categoryName, domainId)
                .stream()
                .map(CategoryArticle::toDto)
                .toList();
    }

    private CategoryArticle setCategoryArticleFromDto(CategoryArticleDto dto, CategoryArticle categoryArticle) {
        categoryArticle.setOrderNumber(dto.getOrderNumber());
        categoryArticle.setCategory(categoryService.getCategoryById(dto.getCategory().getId()));
        categoryArticle.setArticle(articleService.getArticleById(dto.getArticle().getId()));
        return categoryArticle;
    }

    private void checkCategoryArticleExist(CategoryArticleDto dto) {
        repository.findCategoryArticleByOrderNumber(dto.getOrderNumber()).ifPresent(categoryArticle -> {
            throw new EntityExistsException(
                    String.format("Entity %s already exists", categoryArticle.getOrderNumber())
            );
        });
    }
}
