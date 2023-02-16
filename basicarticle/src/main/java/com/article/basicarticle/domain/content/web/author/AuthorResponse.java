package com.article.basicarticle.domain.content.web.author;

import com.article.basicarticle.domain.content.api.author.AuthorDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AuthorResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String  name;
    private final String image;

    public static AuthorResponse fromDto(AuthorDto author){
        return AuthorResponse.builder()
                .id(author.getId())
                .created(author.getCreated())
                .modified(author.getModified())
                .name(author.getName())
                .image(author.getImage())
                .build();
    }
}
