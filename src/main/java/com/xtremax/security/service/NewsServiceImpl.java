package com.xtremax.security.service;

import com.xtremax.security.model.News;
import com.xtremax.security.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

  @Autowired
  private NewsRepository newsRepository;

  @Override
  public List<News> getListNews() {
    return newsRepository.findAll();
  }

  @Override
  public News getNews(Long id) {
    return newsRepository.findById(id).get();
  }

  @Override
  public boolean createNews(News news) {
    News result = newsRepository.save(news);
    return result != null;
  }

  @Override
  public News findByTitle(String title) {
    return newsRepository.findByTitle(title);
  }

  @Override
  public News findByAuthor(String author) {
    return newsRepository.findByAuthor(author);
  }
}
