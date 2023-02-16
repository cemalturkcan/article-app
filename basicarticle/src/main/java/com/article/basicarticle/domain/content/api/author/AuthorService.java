package com.article.basicarticle.domain.content.api.author;


import com.article.basicarticle.domain.content.impl.author.Author;

import java.util.List;

public interface AuthorService {

    AuthorDto createAuthor(AuthorDto dto);

    List<AuthorDto> getAuthors();


    AuthorDto updateAuthor(String id, AuthorDto dto);

    Author getAuthorById(String id);

    void deleteAuthor(String id);
}
