package com.article.basicarticle.domain.content.impl.author;

import com.article.basicarticle.domain.content.api.author.AuthorDto;
import com.article.basicarticle.library.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Author.TABLE,
        indexes = {
        @Index(name = Author.NAME_INDEX, columnList = Author.COL_NAME)
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = Author.COL_NAME)
        })
public class Author extends AbstractEntity {
    public static final String TABLE = "author";
    public static final String NAME_INDEX = "author_i_name";
    public static final String COL_NAME = "name";
    public static final String COL_IMAGE = "image";

    @Column(name = COL_NAME, nullable = false)
    private String name;
    @Column(name =COL_IMAGE)
    private String image;

    public AuthorDto toDto(){
        return AuthorDto.builder()
                .id(this.getId())
                .created(this.getCreated())
                .modified(this.getModified())
                .name(this.getName())
                .image(this.getImage())
                .build();
    }
}
