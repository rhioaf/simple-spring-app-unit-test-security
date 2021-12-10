package com.xtremax.security.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "NEWS")
public class News {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "NEWS_SEQ")
  @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "NEWS_SEQUENCE", allocationSize = 1)
  private Long id;

  @Column(name = "TITLE")
  @NotNull
  private String title;

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "PUBLISHED_DATE")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date publishedDate;

  @Column(name = "AUTHOR")
  @NotNull
  private String author;

  public News() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Date publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
