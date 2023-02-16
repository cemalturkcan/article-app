package com.article.basicarticle.domain.content.impl.category;

import com.article.basicarticle.domain.application.impl.DomainServiceImpl;
import com.article.basicarticle.domain.content.api.category.CategoryDto;
import com.article.basicarticle.domain.content.api.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final DomainServiceImpl domainService;
    private final CategoryRepository repository;

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category category = new Category();
        setCategoryFromDto(dto, category);
        return repository.save(category).toDto();
    }

    private Category setCategoryFromDto(CategoryDto dto, Category category) {
        category.setName(dto.getName());
        category.setCode(dto.getCode());
        category.setDomainId(domainService.getDomain(dto.getDomain().getId()).getId());
        return category;
    }

    @Override
    public void deleteCategory(String id) {

        repository.delete(repository.findById(id).orElseThrow(EntityExistsException::new));
    }

    @Override
    public CategoryDto updateCategory(String id, CategoryDto dto) {
        return repository.findById(id)
                .map(category -> setCategoryFromDto(dto, category))
                .map(repository::save)
                .map(Category::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<CategoryDto> list() {
        return repository.findAll().stream()
                .map(Category::toDto)
                .toList();
    }

    @Override
    public Category getCategoryById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category Not found exceeption"));
    }

    @Override
    public CategoryDto findCategoryByCode(String code) {
        return repository.findCategoryByCode(code).orElseThrow(() -> new EntityNotFoundException("Category Not found exceeption")).toDto();
    }

    @Override
    public List<CategoryDto> getCategoriesByCode(String code) {
        return repository.findAllByCode(code).stream()
                .map(Category::toDto)
                .toList();
    }


}
