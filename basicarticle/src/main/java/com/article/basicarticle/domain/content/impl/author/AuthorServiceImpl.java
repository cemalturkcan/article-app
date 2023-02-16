package com.article.basicarticle.domain.content.impl.author;

import com.article.basicarticle.domain.content.api.author.AuthorDto;
import com.article.basicarticle.domain.content.api.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Override
    @Transactional
    public AuthorDto createAuthor(AuthorDto dto){
        checkAuthorExist(dto);
        Author author = new Author();
        setAuthorFromDto(dto, author);
        return repository.save(author).toDto();
    }
    @Override
    public List<AuthorDto> getAuthors(){
        return repository.findAll().stream()
                .map(Author::toDto)
                .toList();
    }
    @Override
    @Transactional
    public AuthorDto updateAuthor(String id, AuthorDto dto){
        return repository.findById(id)
                .map(author -> setAuthorFromDto(dto,author))
                .map(repository::save)
                .map(Author::toDto)
                .orElseThrow(EntityNotFoundException::new);

    }
    @Override
    public Author getAuthorById(String id){
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("Author Not found exception"));
    }

    @Override
    public void deleteAuthor(String id) {
        repository.delete(repository.findById(id).orElseThrow(EntityExistsException::new));
    }

    private Author setAuthorFromDto(AuthorDto dto, Author author) {
        author.setName(dto.getName());
        author.setImage(dto.getImage());
        return author;
    }
    private void checkAuthorExist(AuthorDto dto){
        repository.findByName(dto.getName()).ifPresent(author -> {
            throw new EntityExistsException(
                    String.format("Entity %s already exists",author.getName())
            );
        });
    }

}
