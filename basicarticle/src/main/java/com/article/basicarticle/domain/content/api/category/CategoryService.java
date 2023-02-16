package com.article.basicarticle.domain.content.api.category;


import com.article.basicarticle.domain.content.impl.category.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto);

    void deleteCategory(String id);

    CategoryDto updateCategory(String id, CategoryDto dto);

    List<CategoryDto> list();

    Category getCategoryById(String id);

    CategoryDto findCategoryByCode(String code);

    List<CategoryDto> getCategoriesByCode(String code);
}
