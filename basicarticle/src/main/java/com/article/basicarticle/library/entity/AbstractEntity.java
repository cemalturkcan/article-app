package com.article.basicarticle.library.entity;

import lombok.Getter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date created;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column
  private Date modified;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "[id" + id + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    AbstractEntity that = (AbstractEntity) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
