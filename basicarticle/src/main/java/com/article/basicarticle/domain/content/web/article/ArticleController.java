package com.article.basicarticle.domain.content.web.article;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.article.ArticleService;
import com.article.basicarticle.library.rest.BaseController;
import com.article.basicarticle.library.rest.DataResponse;
import com.article.basicarticle.library.rest.MetaResponse;
import com.article.basicarticle.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "articles")
@RequiredArgsConstructor
public class ArticleController extends BaseController {

    private final ArticleService service;

    @PostMapping
    public Response<ArticleResponse> createArticle(@Valid @RequestBody ArticleRequest request) {
        var article = service.createArticle(request.toDto());
        return respond(ArticleResponse.fromDto(article));
    }

    @GetMapping
    public Response<DataResponse<ArticleResponse>> articleList() {
        var articles = service.getArticles();
        return respond(toResponse(articles));
    }

    @PutMapping("/{id}")
    public Response<ArticleResponse> updateArticle(@PathVariable(value = "id") String id, @Valid @RequestBody ArticleRequest request) {
        var article = service.updateArticle(id, request.toDto());
        return respond(ArticleResponse.fromDto(article));
    }

    @DeleteMapping("/{id}")
    public Response<MetaResponse> deleteArticle(@PathVariable(value = "id") String id) {
        service.deleteArticle(id);
        return new Response<>(MetaResponse.ofSuccess());
    }

    @DeleteMapping("/define/{slug}")
    public Response<ArticleResponse> defineBySlug(@PathVariable(value = "slug") String slug) {
        var article = service.defineArticleBySlug(slug);
        return respond(ArticleResponse.fromDto(article));
    }

    private List<ArticleResponse> toResponse(List<ArticleDto> articleDtoList) {
        return articleDtoList.stream().map(ArticleResponse::fromDto).toList();
    }
}
