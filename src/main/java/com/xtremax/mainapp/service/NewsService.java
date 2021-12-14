package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.News;

import java.util.List;

public interface NewsService {
  List<News> getListNews();
  News getNews(Long id);
  boolean createNews(News news);
  News findByTitle(String title);
  News findByAuthor(String author);
}
