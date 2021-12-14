package com.xtremax.mainapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xtremax.mainapp.model.News;
import com.xtremax.mainapp.repository.NewsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NewsRepositoryTests {

  @Autowired
  private TestEntityManager manager;

  @Autowired
  private NewsRepository newsRepository;

  @BeforeEach
  public void setUp() {
    News news1 = new News();
    news1.setTitle("berita 1");
    news1.setContent("konten 1");
    news1.setAuthor("tester 1");
    news1.setPublishedDate(new Date());
    this.manager.persist(news1);

    News news2 = new News();
    news2.setTitle("berita 2");
    news2.setContent("konten 2");
    news2.setAuthor("tester 2");
    news2.setPublishedDate(new Date());
    this.manager.persist(news2);
  }

  @AfterEach
  public void tearDown() {}

  @Test
  public void givenNewsTitle_titleShouldMatch() {
    News news = newsRepository.findByTitle("berita 2");
    assertEquals("berita 2", news.getTitle());
  }

  @Test
  public void givenNewsTitle_authorShouldMatch() {
    News news = newsRepository.findByTitle("berita 1");
    assertEquals("tester 1", news.getAuthor());
  }

  @Test
  public void givenNewsTitle_contentShouldMatch() {
    News news = newsRepository.findByTitle("berita 2");
    assertEquals("konten 2", news.getContent());
  }

  @Test
  public void givenNewsAuthor_titleShouldMatch() {
    News news = newsRepository.findByAuthor("tester 1");
    assertEquals("berita 1", news.getTitle());
  }
}
