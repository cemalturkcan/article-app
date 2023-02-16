package com.article.basicarticle.domain.content.api.author;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AuthorDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String  name;
    private final String image;
}
