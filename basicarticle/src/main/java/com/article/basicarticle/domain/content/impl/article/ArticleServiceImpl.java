package com.article.basicarticle.domain.content.impl.article;

import com.article.basicarticle.domain.content.api.article.ArticleDto;
import com.article.basicarticle.domain.content.api.article.ArticleService;
import com.article.basicarticle.domain.content.api.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;

    private final AuthorService authorService;

    @Override
    @Transactional
    public ArticleDto createArticle(ArticleDto dto) {
        Article article = new Article();
        setArticleFromDto(dto, article);
        return repository.save(article).toDto();
    }

    @Override
    public List<ArticleDto> getArticles() {
        return repository.findAll().stream()
                .map(Article::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ArticleDto updateArticle(String id, ArticleDto dto) {
        return repository.findById(id)
                .map(article -> setArticleFromDto(dto, article))
                .map(repository::save)
                .map(Article::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Article getArticleById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Article Not found exceeption"));
    }

    @Override
    public void deleteArticle(String id) {
        repository.delete(repository.findById(id).orElseThrow(EntityExistsException::new));
    }

    @Override
    public ArticleDto defineArticleBySlug(String slug) {
        return repository.findArticleBySlug(slug).orElseThrow(() -> new EntityNotFoundException("Article Not found exceeption")).toDto();
    }

    private Article setArticleFromDto(ArticleDto dto, Article article) {
        article.setTitle(dto.getTitle());
        article.setHtmlBody(dto.getHtmlBody());
        article.setSeoTitle(dto.getSeoTitle());
        article.setSeoDescription(dto.getSeoDescription());
        article.setSeoKeywords(dto.getSeoKeywords());
        if(article.getSlug() == null){
            article.setSlug(convertToSlug(dto.getTitle()));
        }
        else{
            article.setSlug(dto.getSlug());
        }
        article.setActive(dto.isActive());
        article.setAuthor(authorService.getAuthorById(dto.getAuthor().getId()));
        return article;
    }


    private String convertToSlug(String title) {
        final Pattern NONLATIN = Pattern.compile("[^\\w-]");
         final Pattern WHITESPACE = Pattern.compile("[\\s]");
            String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
            String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
            String slug = NONLATIN.matcher(normalized).replaceAll("");
            return slug.toLowerCase(Locale.ENGLISH);
    }

}

