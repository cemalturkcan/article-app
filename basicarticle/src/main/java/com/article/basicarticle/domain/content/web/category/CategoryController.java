package com.article.basicarticle.domain.content.web.category;

import com.article.basicarticle.domain.content.api.category.CategoryDto;
import com.article.basicarticle.domain.content.api.category.CategoryService;
import com.article.basicarticle.library.rest.BaseController;
import com.article.basicarticle.library.rest.DataResponse;
import com.article.basicarticle.library.rest.MetaResponse;
import com.article.basicarticle.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController {

    private final CategoryService service;

    @GetMapping
    public Response<DataResponse<CategoryResponse>> getCategories() {
        List<CategoryDto> departmentDtoList = service.list();
        return respond(toResponse(departmentDtoList));
    }

    @PostMapping
    public Response<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        var category = service.createCategory(request.toDto());
        return respond(CategoryResponse.fromDto(category));
    }

    @PutMapping("/{id}")
    public Response<CategoryResponse> updateCategory(@PathVariable(value = "id") String id, @Valid @RequestBody CategoryRequest request) {
        var domain = service.updateCategory(id, request.toDto());
        return respond(CategoryResponse.fromDto(domain));
    }


    @GetMapping("/filter")
    public Response<DataResponse<CategoryResponse>> getCategoriesByCode(@RequestParam(value = "code") String code) {
        List<CategoryDto> departmentDtoList = service.getCategoriesByCode(code);
        return respond(toResponse(departmentDtoList));
    }


    @DeleteMapping("/{id}")
    public Response<MetaResponse> deleteCategory(@PathVariable(value = "id") String id) {
        service.deleteCategory(id);
        return new Response<>(MetaResponse.ofSuccess());
    }


    private List<CategoryResponse> toResponse(List<CategoryDto> categoryList) {
        return categoryList.stream().map(CategoryResponse::fromDto).toList();
    }
}
