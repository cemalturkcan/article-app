package com.article.basicarticle.domain.content.web.author;

import com.article.basicarticle.domain.content.api.author.AuthorDto;
import com.article.basicarticle.domain.content.api.author.AuthorService;
import com.article.basicarticle.library.rest.BaseController;
import com.article.basicarticle.library.rest.DataResponse;
import com.article.basicarticle.library.rest.MetaResponse;
import com.article.basicarticle.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "authors")
@RequiredArgsConstructor
public class AuthorController extends BaseController {

    private final AuthorService service;

    @PostMapping
    public Response<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest request) {
        var author = service.createAuthor(request.toDto());
        return respond(AuthorResponse.fromDto(author));
    }

    @GetMapping
    public Response<DataResponse<AuthorResponse>> authorList() {
        var authors = service.getAuthors();
        return respond(toResponse(authors));
    }

    @PutMapping("/{id}")
    public Response<AuthorResponse> updateAuthor(@PathVariable(value = "id") String id, @Valid @RequestBody AuthorRequest request) {
        var author = service.updateAuthor(id, request.toDto());
        return respond(AuthorResponse.fromDto(author));
    }

    @DeleteMapping("/{id}")
    public Response<MetaResponse> deleteAuthor(@PathVariable(value = "id") String id) {
        service.deleteAuthor(id);
        return new Response<>(MetaResponse.ofSuccess());
    }

    private List<AuthorResponse> toResponse(List<AuthorDto> authorDtoList) {
        return authorDtoList.stream().map(AuthorResponse::fromDto).toList();
    }

}
