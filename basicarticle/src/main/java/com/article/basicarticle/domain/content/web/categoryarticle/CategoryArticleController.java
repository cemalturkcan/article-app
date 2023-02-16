package com.article.basicarticle.domain.content.web.categoryarticle;

import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleDto;
import com.article.basicarticle.domain.content.api.categoryarticle.CategoryArticleService;
import com.article.basicarticle.library.rest.BaseController;
import com.article.basicarticle.library.rest.DataResponse;
import com.article.basicarticle.library.rest.MetaResponse;
import com.article.basicarticle.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "category-articles")
@RequiredArgsConstructor
public class CategoryArticleController extends BaseController {

    private final CategoryArticleService service;

    @PostMapping
    public Response<CategoryArticleResponse> createCategoryArticle(@Valid @RequestBody CategoryArticleRequest request) {
        var categoryArticle = service.createCategoryArticle(request.toDto());
        return respond(CategoryArticleResponse.fromDto(categoryArticle));
    }

    @GetMapping
    public Response<DataResponse<CategoryArticleResponse>> getCategoryArticles() {
        var categoryArticles = service.getCategoryArticles();
        return respond(toResponse(categoryArticles));
    }

    @GetMapping("/filter")
    public Response<DataResponse<CategoryArticleResponse>> getCategoryArticlesByCategoryNameAndDomainId(@RequestParam String categoryName, @RequestParam String domainId) {
        List<CategoryArticleDto> categoryArticles = service.getCategoryArticlesByCategoryNameAndDomainId(categoryName, domainId);
        return respond(toResponse(categoryArticles));
    }

    @PutMapping("/{id}")
    public Response<CategoryArticleResponse> updateCategoryArticle(@PathVariable(value = "id") String id, @Valid @RequestBody CategoryArticleRequest request) {
        var categoryArticle = service.updateCategoryArticle(id, request.toDto());
        return respond(CategoryArticleResponse.fromDto(categoryArticle));
    }


    @DeleteMapping("/{id}")
    public Response<MetaResponse> deleteCategoryArticle(@PathVariable(value = "id") String id) {
        service.deleteCategoryArticle(id);
        return new Response<>(MetaResponse.ofSuccess());
    }


    private List<CategoryArticleResponse> toResponse(List<CategoryArticleDto> categoryArticleDtoList) {
        return categoryArticleDtoList.stream().map(CategoryArticleResponse::fromDto).toList();
    }
}
