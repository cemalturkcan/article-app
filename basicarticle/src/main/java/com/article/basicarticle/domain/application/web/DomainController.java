package com.article.basicarticle.domain.application.web;

import com.article.basicarticle.domain.application.api.DomainDto;
import com.article.basicarticle.domain.application.api.DomainService;
import com.article.basicarticle.library.rest.BaseController;
import com.article.basicarticle.library.rest.DataResponse;
import com.article.basicarticle.library.rest.MetaResponse;
import com.article.basicarticle.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "domains")
@RequiredArgsConstructor
public class DomainController extends BaseController {

    private final DomainService service;

    @PostMapping
    public Response<DomainResponse> createDomain(@Valid @RequestBody DomainRequest request) {
        var domain = service.createDomain(request.toDto());
        return respond(DomainResponse.fromDto(domain));
    }

    @GetMapping
    public Response<DataResponse<DomainResponse>> getDomainList() {
        var domains = service.getDomains();
        return respond(toResponse(domains));
    }

    @GetMapping("/filter")
    public Response<DomainResponse> getDomainByName(@RequestParam(value = "id") String id) {
        var domain = service.getDomainById(id);
        return respond(DomainResponse.fromDto(domain));
    }

    @PutMapping("/{id}")
    public Response<DomainResponse> updateDomain(@PathVariable(value = "id") String id, @Valid @RequestBody DomainDto dto) {
        var domain = service.updateDomain(id, dto);
        return respond(DomainResponse.fromDto(domain));
    }

    @DeleteMapping("/{id}")
    public Response<MetaResponse> deleteDomain(@PathVariable(value = "id") String id) {
        service.deleteDomain(id);
        return new Response<>(MetaResponse.ofSuccess());
    }

    private List<DomainResponse> toResponse(List<DomainDto> domainDtoList) {
        return domainDtoList.stream().map(DomainResponse::fromDto).toList();
    }
}
