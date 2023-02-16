package com.article.basicarticle.domain.content.web.author;

import com.article.basicarticle.domain.content.api.author.AuthorDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AuthorRequest {
    @NotBlank
    private final String name;
    private final String image;

    public AuthorDto toDto(){
        return AuthorDto.builder()
                .name(name)
                .image(image)
                .build();
    }
}
